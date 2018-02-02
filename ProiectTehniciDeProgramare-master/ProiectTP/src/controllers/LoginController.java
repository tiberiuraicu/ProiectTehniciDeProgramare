
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
import objects.entities.Administrator;
import objects.entities.Client;
import objects.loginData.LoginData;


@Controller
@RequestMapping("/login")
public class LoginController {
	DatabaseOperations db = new DatabaseOperations();

	@RequestMapping("/")
	public String loginPage(Model model) {
		LoginData loginData = new LoginData();
		model.addAttribute("loginForm", loginData);
		return "login";
	}

	@ResponseBody
	@RequestMapping("/login")
	private ModelAndView loginDataReciver(ModelAndView modelAndView,
			@Valid @ModelAttribute("loginForm") LoginData loginData, Model model,
			RedirectAttributes redirectAttributes) {

		Client clientExistent = db.getClientByEmail(loginData.getLoginEmail());
		Administrator administratorExistent = db.getAdministratorByEmail(loginData.getLoginEmail());

		if (clientExistent != null) {

			if ((clientExistent.getPassword()).equals(loginData.getLoginPassword())) {
				if (clientExistent.getToken().equals("activat")) {
					redirectAttributes.addFlashAttribute("user", clientExistent);
					modelAndView.setViewName("redirect:/Client/");	
				}
				else
				{
					modelAndView.setViewName("redirect:/login/");
				}
			}

		} else if (administratorExistent != null) {
			if (administratorExistent.getPassword().equals(loginData.getLoginPassword())) {
				modelAndView.setViewName("redirect:/Administrator/");
			}
		} else {

			modelAndView.setViewName("redirect:/login/");
		}

		return modelAndView;

	}
}
