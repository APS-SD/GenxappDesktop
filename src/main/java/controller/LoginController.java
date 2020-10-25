package controller;

import domain.LoginPerformer;
import model.CredentialLoginModel;


public class LoginController{
	
	public LoginController() {
		
	}

	public static boolean logon(String username, String password){

		CredentialLoginModel user = new CredentialLoginModel(username, password); 
		boolean response;
                
		try {
		    
                    response = LoginPerformer.performLogin(user);
		} catch (Exception e) {
		    return false;
		}
		
                return response;
	}
	

}
