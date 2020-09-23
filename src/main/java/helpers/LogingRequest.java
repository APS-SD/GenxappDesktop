package helpers;

import com.google.gson.Gson;

import model.TokenModel;
import model.UserModel;
import model.LoginRequestModel;

public class LogingRequest implements LoginRequestModel{
	private String urlEndPoint;
	private String userJson;
	private Gson JsonConversor;
	
	public LogingRequest() {
		super();
		JsonConversor = new Gson();
	}

	public LoginRequestModel assembleLoginRequest (UserModel user) {		
    	userJson = JsonConversor.toJson(user);
    	urlEndPoint = "https://genxapp.herokuapp.com"
    					+"/api/v1/login/?format=json";
    	return this;
	}
	
	public TokenModel sendLoginRequest() throws Exception{
		HTTPClient client = new HTTPClient();
		return JsonConversor.fromJson(
								client.sendPost(urlEndPoint,userJson)
								,TokenModel.class
							);	
	}
}
