package controller;

import domain.LoginPerformer;
import model.UserModel;

public class Login {
	private LoginPerformer loginPer;
	
	public void Logon(String identifier, String password) throws Exception {		
		loginPer.performLogin(new UserModel(identifier,password));		
	}

}
