package controller;

import domain.LoginPerformer;
import model.UserModel;

public class Login {
	
	public void Logon(String identifier, String password) throws Exception {		
		LoginPerformer.performLogin(new UserModel(identifier,password));		
			
                
	}

}
