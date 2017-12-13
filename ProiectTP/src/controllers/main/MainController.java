package controllers.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class MainController {
	
	@RequestMapping("/")
	private String loginRegister() {
		return "index";
	}
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
	}
}
