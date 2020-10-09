package domain;

import helpers.LoginRequestFactory;
import helpers.RefreshRequestFactory;
import model.TokenModel;
import model.UserModel;
import domain.Session;


public class LoginPerformer {
	TokenModel token;
	UserModel user;
	
	private void requestPrimaryLogin() throws Exception {//Change to loginException
		token = LoginRequestFactory
					.getLoginRequest()
					.assembleLoginRequest(user)
					.sendLoginRequest()
				.getToken();
				
	}
	
	private void requestDefinitiveLogin()throws Exception{
		token = RefreshRequestFactory
					.getRefreshRequest(token)
					.assembleRefreshRequest(token)
					.sendRefreshRequest()
				.getToken();
	}

	public static void performLogin(UserModel user) throws Exception{		
		LoginPerformer lp = new LoginPerformer();
		lp.user = user;
		lp.requestPrimaryLogin();
		lp.requestDefinitiveLogin();
								
		
		System.out.println(lp.token.toString());
	}
}
