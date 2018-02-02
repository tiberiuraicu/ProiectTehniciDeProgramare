package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import database.main.DatabaseOperations;
import objects.entities.Client;
import objects.entities.PendingOrder;
import server.administratorOperations.AdministratorMese;
import server.clientOperations.ClientFoodBasketOperations;

@Controller
@RequestMapping("/Administrator")
public class AdministratorController {
	Client clientInSession = new Client();
	ClientFoodBasketOperations clientFoodBasketOperations = new ClientFoodBasketOperations();
	DatabaseOperations databaseOperations = new DatabaseOperations();
    AdministratorMese administratorMese = new AdministratorMese();
	
	@RequestMapping("/")
	private String client() {
		return "Administrator";

	}
	@RequestMapping("/orderStatus")
	public String orderStatus(Model model) {
		List<PendingOrder> pendingOrders = clientFoodBasketOperations
				.getClientPendingOrders("tiberiuraicu2@gmail.com");
	
		model.addAttribute("pendingOrders", pendingOrders);
		return "Administrator";
	}
	
	@RequestMapping("/salvareMese")
	public @ResponseBody void salvareMese(@RequestBody String asezareMese) {
		System.out.println(asezareMese);
		administratorMese.getTables(asezareMese);
		

	}
	
	@RequestMapping("/aranjareMese")
	public String paginaAranjareMese() {
	
		return "AsezareMese";
	}
}
