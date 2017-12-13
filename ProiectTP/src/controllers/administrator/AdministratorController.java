package controllers.administrator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Administrator")
public class AdministratorController {

	@RequestMapping("/")
	private String client() {
		return "Administrator";

	}
}
