package domain;

import com.google.gson.Gson;
import config.Endpoint;
import helpers.HTTPClient;
import model.TokenModel;
import model.CredentialLoginModel;
import model.RequestModel;

public class LoginRequest extends RequestModel{
	
    protected String userJson;

    public LoginRequest() {
        super();
        this.JsonConversor = new Gson();
        this.client = new HTTPClient();        
        this.urlEndpoint = Endpoint.getAuthentication();          
    }
    
    public void assembleLogingRequest(CredentialLoginModel user) {
    	this.userJson = JsonConversor.toJson(user);
    }
    
    private TokenModel sendRequest() throws Exception{
        System.out.println(this.urlEndpoint);
        System.out.println(this.userJson);
        String json =  client.sendPost(this.urlEndpoint,this.userJson);
       
        return JsonConversor.fromJson(json,TokenModel.class);
    }

    public TokenModel getToken() throws Exception{
        return this.sendRequest();
    }
    
    
        
    
}
