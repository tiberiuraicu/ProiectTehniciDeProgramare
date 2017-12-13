package controllers.client;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.core.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import objects.entities.Client;

@Controller
@RequestMapping("/Client")
@Scope("session")
@SessionAttributes("username")
public class ClientController {

	@RequestMapping("/")
	private ModelAndView client(ModelAndView modelAndView, ModelMap modelMap, @ModelAttribute("user") Client client) {
		System.out.println(client.getEmail());
		if (client.getEmail() == null) {
			modelAndView.setViewName("redirect:/login/");
		} else {

			modelAndView.setViewName("Client");
		}
		return modelAndView;
	}
}
