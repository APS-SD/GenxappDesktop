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
    
    public boolean assembleToken(){
        System.out.println(this.urlEndpoint);
        
        Response response =  client.sendPost(this.urlEndpoint,this.userJson);
       
        if(response.getStatus_code() == 200){        
            this.token = JsonConversor.fromJson(response.getContent(),TokenModel.class);    
        }else{
            return false;
        }
        
        return true;
    }

    public TokenModel getToken() throws Exception{
        return this.token;
    }
    
    
        
    
}
