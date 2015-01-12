package pl.lodz.p.project.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


/**
 * 
 * @author Milczu
 *
 */
@Controller
public class MainController {

	public static final String DOCUMENT_PARAM = "document";

	@RequestMapping("/login-page")
	public String login() {
		return "/login/login.xhtml";
	}

	@RequestMapping(value = "/document", method = RequestMethod.GET)
	public void get(HttpSession session, Model model) {
		Object document = session.getAttribute(DOCUMENT_PARAM);
		model.addAttribute(DOCUMENT_PARAM, document);
	}
	
}
