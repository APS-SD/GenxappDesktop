package helpers;

import model.LoginRequestModel;
import helpers.LoginRequest;

public class LoginRequestFactory {
	public static LoginRequestModel getLoginRequest() {		
		return new LoginRequest();
	}
}
