package pl.lodz.p.project.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.lodz.p.project.commons.system.SystemInfo;


/**
 * 
 * @author Milczu
 *
 */
@Controller
public class MainController {

	@Autowired
	private SystemInfo systemInfo;

	@ResponseBody
	@RequestMapping("/system-info")
	public String systemInfo() {
		return systemInfo.getSystemName();
	}
	
	@RequestMapping("/login-page")
	public String login() {
		return "/login/login.xhtml";
	}
	
}
