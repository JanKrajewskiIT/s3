package pl.lodz.p.project.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * @author Milczu
 *
 */
@Controller
public class MainController {
	
	@RequestMapping("/login-page")
	public String login() {
		return "/login/login.xhtml";
	}
	
}
