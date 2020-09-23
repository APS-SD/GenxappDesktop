package controller;

import domain.LoginPerformer;
import model.UserModel;

public class Login {
	private UserModel user;
	
	public void Logon(String identifier, String password) throws Exception {
		
		user = new UserModel(identifier,password);
		LoginPerformer.performLogin(user);
	}

}
