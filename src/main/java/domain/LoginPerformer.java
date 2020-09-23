package domain;

import serializer.UserSerializer;
import model.UserModel;
import helpers.LogingRequest;
import model.TokenModel;

public class LoginPerformer {
	LogingRequest login;

	public static void performLogin(UserModel user) throws Exception{
		
		LoginPerformer lp = new LoginPerformer();
		
		lp.login = new LogingRequest();
		
		TokenModel tm = lp.login
							.assembleLoginRequest(user)
							.sendLoginRequest();		
		
		//Remove
		System.out.println(tm.getAccess());
									
	}
}
