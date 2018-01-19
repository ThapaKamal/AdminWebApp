/**
 * LoginServiceImpl.java
 * @author Kamal Thapa(KT)
 * @Created Jan 17, 2018
 * 
 */
package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDAO loginDAO;
	
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO=loginDAO;
	}
	
	@Override
	public boolean checkLogin(String username, String password) {
		System.out.println("In Service Class..Check login");
		return loginDAO.checklogin(username, password);
		
		
	}

}
