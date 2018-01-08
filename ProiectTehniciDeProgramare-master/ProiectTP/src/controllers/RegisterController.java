package controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import database.main.DatabaseOperations;
import objects.entities.Client;



@Controller
@RequestMapping("/register")
public class RegisterController {
	DatabaseOperations db = new DatabaseOperations();

	@RequestMapping("/")
	public String loginPage(Model model) {
		Client user = new Client();
		model.addAttribute("registerForm", user);
		return "register";
	}

	@ResponseBody
	@RequestMapping("/register")
	private ModelAndView registerDataReceiver(ModelAndView modelAndView,
			@Valid @ModelAttribute("registerForm") Client client, Model model,RedirectAttributes redirectAttrs) {
		System.out.println(client.getEmail());

		Client clientExistent = db.getClientByEmail(client.getEmail());
		System.out.println(client);

		if (clientExistent != null) {
			modelAndView.addObject("Message", "Oops!  There is already a user registered with the email provided.");
			modelAndView.setViewName("redirect:/register/");
		} else {
		
			db.clientInsert(client);
			redirectAttrs.addFlashAttribute("clientEmail", client.getEmail());
			modelAndView.setViewName("redirect:/email/sent");
		}
		return modelAndView;
	}

}
