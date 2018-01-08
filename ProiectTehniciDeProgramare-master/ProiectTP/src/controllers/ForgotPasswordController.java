package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import database.main.DatabaseOperations;
import objects.entities.Client;
import objects.passwordRecovery.EmailToRecover;
import objects.passwordRecovery.NewPassword;
import server.emailOperations.forgotPassword.ForgotPasswordEmailSender;

@Controller
@RequestMapping("/recovery")
public class ForgotPasswordController {
	DatabaseOperations db = new DatabaseOperations();

	@RequestMapping("/")
	public String recovery(Model model) {
		EmailToRecover recoveryEmail = new EmailToRecover();
		model.addAttribute("recoveryEmail", recoveryEmail);
		return "Forgot-password";

	}

	@RequestMapping("/sendRecoveryEmail")
	public ModelAndView sendRecoveryMail(ModelAndView modelAndView,
			@ModelAttribute("recoveryEmail") EmailToRecover recoveryEmail) {
		Client clientExistent = db.getClientByEmail(recoveryEmail.getRecoverEmail());
		if (clientExistent != null) {
			if (clientExistent.getEnabled().equals("false")) {
				modelAndView.setViewName("Forgot-password");
				modelAndView.addObject("mesaj", "Contul nu exista sau nu este activat");
			} else {
				ForgotPasswordEmailSender forgot = new ForgotPasswordEmailSender(recoveryEmail.getRecoverEmail());
				modelAndView.setViewName("Forgot-password");
				modelAndView.addObject("mesaj", "Un email a fost trimis la adresa mentionata");
			}
		} else {
			modelAndView.setViewName("Forgot-password");
			modelAndView.addObject("mesaj", "Contul nu exista");
		}
		return modelAndView;
	}

	@RequestMapping("/{forgotPasswordToken}")
	public String forgotPassword(Model model, @PathVariable(value = "forgotPasswordToken") String forgotPasswordToken) {
		Client client = db.getClientByForgotPasswordToken(forgotPasswordToken);
		if (client != null) {
			NewPassword newPassword = new NewPassword();
			model.addAttribute("token_activare", forgotPasswordToken);
			model.addAttribute("newPasswordForm", newPassword);
			return "recover";
		} else {
			return "error";
		}
	}

	@RequestMapping("/setNewPassoword")
	public String setNewPassoword(ModelAndView modelAndView,
			@ModelAttribute("newPasswordForm") NewPassword newPassword) {
		Client client = db.getClientByForgotPasswordToken(newPassword.getToken());

		if (client != null) {
			client.setPasswordRecoveryToken("null");
			client.setPassword(newPassword.getPassword());
			db.updateClient(client);
			return "redirect:/login/";
		} else {
			return "redirect:/error/";
		}
	}
}
