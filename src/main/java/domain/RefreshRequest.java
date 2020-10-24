package domain;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import config.Endpoint;
import helpers.HTTPClient;
import model.RequestModel;
import model.TokenModel;

public class RefreshRequest extends RequestModel{

    private String payload;

    public RefreshRequest() {
        super();
        this.client = new HTTPClient();
        this.urlEndpoint = Endpoint.getRefresh();          
    }
    
    private void initializeRequest(TokenModel token) {
    	this.token = token;
    	
    	try {
            this.payload = makePayload(token);
        } catch (JSONException e) {
            this.payload = "";
        }
    }

    private String makePayload(TokenModel token) throws JSONException {
        
        JSONObject jo = new JSONObject();

        return jo.put("refresh", token.getRefresh()).toString();
    }

    private String GetRequestResponse() {
        
        return this.client.sendPost(this.urlEndpoint,this.payload);
               
    }
    
    public void assembleToken(TokenModel token){
    	initializeRequest(token);
    	
        String definitiveToken = this.GetRequestResponse();
        
        this.token.setDefinitiveAccess(definitiveToken);              
    }
    
    public TokenModel getToken() {
    	return this.token;
    }
}
