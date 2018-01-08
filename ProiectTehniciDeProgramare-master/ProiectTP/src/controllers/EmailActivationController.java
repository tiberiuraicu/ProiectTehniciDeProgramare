package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import database.main.DatabaseOperations;
import objects.entities.Client;
import server.emailOperations.accountActivation.EmailSender;

@Controller
@RequestMapping("/email")
public class EmailActivationController {
	DatabaseOperations db = new DatabaseOperations();

	@RequestMapping("/sent")
	public ModelAndView verificationEmailSent(@ModelAttribute("clientEmail") final String clientEmail,
			ModelAndView modelAndView) {
		System.out.println(clientEmail);
		EmailSender e = new EmailSender(clientEmail);
		modelAndView.setViewName("em-sent");
		modelAndView.addObject("email", clientEmail);
		return modelAndView;
	}

	@RequestMapping("/{token}")
	private String client(Model model, @PathVariable(value = "token") String token) {
		Client client = db.getClientByToken(token);
		if (client != null) {
			client.setEnabled("true");
			client.setToken("activat");
			model.addAttribute("mesaj_activare", "contul a fost activat cu succes");
			db.updateClient(client);
		} else {
			model.addAttribute("mesaj_activare", "contul nu exista sau tokenul a expirat");

		}

		return "confirm";

	}
}
