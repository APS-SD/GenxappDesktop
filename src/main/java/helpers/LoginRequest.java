package helpers;

import model.RequestModel; 
import com.google.gson.Gson;
import config.Endpoint;
import model.TokenModel;
import model.UserLoginModel;
import model.LoginRequestModel;
import model.RequestModel;

public class LoginRequest extends RequestModel implements LoginRequestModel{
	
	public LoginRequest() {
		super();
		JsonConversor = new Gson();
		client = new HTTPClient();
		
	}

	@Override
	public LoginRequestModel assembleLoginRequest (UserLoginModel user) {		
    	userJson = JsonConversor.toJson(user);
    	urlEndpoint = Endpoint.getAuthentication();
    	return this;
	}
	
	@Override
	public LoginRequestModel  sendLoginRequest() throws Exception{
		this.token = JsonConversor.fromJson(
										client.sendPost(urlEndpoint,userJson)
										,TokenModel.class
									);
		return this;
	}

	@Override
	public TokenModel getToken() {
		return this.token;
	}
}
