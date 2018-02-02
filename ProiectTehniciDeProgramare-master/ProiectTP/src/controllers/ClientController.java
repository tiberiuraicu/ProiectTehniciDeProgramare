package controllers;

import java.util.List;

import javax.mail.Session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import database.main.DatabaseOperations;
import objects.entities.Client;
import objects.entities.PendingOrder;
import server.clientOperations.ClientDetailsModifier;
import server.clientOperations.ClientFoodBasketOperations;

@Controller
@RequestMapping("/Client")
@Scope("session")
@SessionAttributes("username")
public class ClientController {
	Client clientInSession = new Client();
	ClientFoodBasketOperations clientFoodBasketOperations = new ClientFoodBasketOperations();
	DatabaseOperations databaseOperations = new DatabaseOperations();

	@RequestMapping("/")
	private ModelAndView client(ModelAndView modelAndView, ModelMap modelMap, @ModelAttribute("user") Client client) {

		if (client.getEmail() == null) {
			if (clientInSession.getEmail() != null) {
				modelAndView.setViewName("Client");
			} else {
				modelAndView.setViewName("redirect:/login/");
			}
		} else {
			clientInSession.setEmail(client.getEmail());
			clientInSession.setPassword(client.getPassword());
			modelAndView.setViewName("Client");
		}
		return modelAndView;
	}

	@RequestMapping("/meniu")
	private ModelAndView showMeniu(ModelAndView modelAndView) {
		modelAndView.setViewName("meniu");
		return modelAndView;
	}

	@RequestMapping("/saveNewAccountInfo")
	public @ResponseBody String checkUsername(@RequestBody String accountDetailsInJson) {
		System.out.println(accountDetailsInJson);
		new ClientDetailsModifier(accountDetailsInJson, clientInSession.getEmail());
		return "merge";

	}

	@RequestMapping("/addFoodInBasket")
	public void addFoodInBasket(@RequestBody String foodName) {

		clientFoodBasketOperations.addToBasket(foodName, clientInSession.getEmail());
	}

	@RequestMapping("/placeOrder")
	public void placeOrder() {
		clientFoodBasketOperations.placeOrder(clientInSession.getEmail());
	}

	@RequestMapping("/orderStatus")
	public String orderStatus(Model model) {
		List<PendingOrder> pendingOrders = clientFoodBasketOperations
				.getClientPendingOrders(clientInSession.getEmail());
		System.out.println(clientInSession.getEmail());
		System.out.println(pendingOrders);
		model.addAttribute("pendingOrders", pendingOrders);
		return "ClientOrderStatusPage";
	}
}
