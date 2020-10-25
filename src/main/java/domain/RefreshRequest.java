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

    private Response GetRequestResponse() {
           
        return this.client.sendPost(this.urlEndpoint,this.payload);       
    }
    
    public boolean assembleToken(TokenModel token){
    	// nao existe token definitivo separado do access
       
        initializeRequest(token);
    	
        Response response = this.GetRequestResponse();
        
        if(response.getStatus_code() == 200){        
            
            this.token = JsonConversor.fromJson(response.getContent(),TokenModel.class);
            this.token.setRefresh(null);
            
        }else{
            return false;
        }
        
        return true;
        
    }
    
    public TokenModel getToken() {
    	return this.token;
    }
}
