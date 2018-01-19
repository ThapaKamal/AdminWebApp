/**
 * LoginController.java
 * @author Kamal Thapa(KT)
 * @Created Jan 17, 2018
 * 
 */
package controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import forms.LoginForm;
import service.LoginService;

@Controller
@RequestMapping("index.jsp")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm= new LoginForm();
		model.put("loginForm", loginForm);
		return "loginForm";
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public String processForm(LoginForm loginForm, BindingResult result, Map model) {
		
		if(result.hasErrors()) {
			return "loginForm";
		}
		
		boolean userExist=loginService.checkLogin(loginForm.getUserName(),loginForm.getPassword());
		if(userExist) {
			model.put("loginForm", loginForm);
			return "loginSuccess";
		}else {
			result.rejectValue("username", "invalidCredentials");
			return "loginForm";
		}
		
		
	}
	
}
