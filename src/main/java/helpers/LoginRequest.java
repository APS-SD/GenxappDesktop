package helpers;

import com.google.gson.Gson;
import config.Endpoint;
import model.TokenModel;
import model.UserLoginModel;
import model.RequestModel;

public class LoginRequest extends RequestModel{
	
    protected String userJson;

    public LoginRequest(UserLoginModel user) {
        super();
        this.JsonConversor = new Gson();
        this.client = new HTTPClient();
        this.userJson = JsonConversor.toJson(user);
        this.urlEndpoint = Endpoint.getAuthentication();          
    }
    
    private TokenModel sendRequest() throws Exception{
        return JsonConversor.fromJson(client.sendPost(urlEndpoint,userJson),TokenModel.class);
    }

    public TokenModel getToken() throws Exception{
        return this.sendRequest();
    }
}
