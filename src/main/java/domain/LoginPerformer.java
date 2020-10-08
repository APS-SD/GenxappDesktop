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

	public void performLogin(UserModel user) throws Exception{		
		this.user = user;
		requestPrimaryLogin();
		requestDefinitiveLogin();
								
		
		System.out.println(token.toString());
	}
}
