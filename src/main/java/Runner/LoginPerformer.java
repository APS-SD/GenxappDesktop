package Runner;

import serializer.UserSerializer;
import model.UserModel;
import helpers.LogingRequest;
import model.TokenModel;

public class LoginPerformer {
	LogingRequest login;

	public static void performLogin
		(String identifier
		,String password)throws Exception{
		
		LoginPerformer lp = new LoginPerformer();
		UserModel user = new UserModel(identifier, password);
		lp.login = new LogingRequest();
		
		TokenModel tm = lp.login
							.assembleLoginRequest(user)
							.sendLoginRequest();
		System.out.println(tm.getAccess());
									
	}
}
