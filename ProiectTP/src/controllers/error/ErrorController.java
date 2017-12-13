package controllers.error;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/errors")
public class ErrorController {
	@RequestMapping("/")
	public String errorPage() {
		return "error";
	}

}
