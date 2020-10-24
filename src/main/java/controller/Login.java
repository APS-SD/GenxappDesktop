package controller;

import domain.LoginPerformer;
import model.UserLoginModel;

public class Login {
	
	public void Logon(String identifier, String password) throws Exception {		
		LoginPerformer.performLogin(new UserLoginModel(identifier,password));		
			
                
	}

}
