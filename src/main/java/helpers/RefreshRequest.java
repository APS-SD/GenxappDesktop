package helpers;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import config.Endpoint;
import model.RequestModel;
import model.TokenModel;

public class RefreshRequest extends RequestModel{

    private String payload;

    public RefreshRequest(TokenModel token) {
        super();
        this.token = token;
        this.client = new HTTPClient();
        this.urlEndpoint = Endpoint.getRefresh();  
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

    private void sendRequest() {
        
        String definitive_token = this.client.sendPost(this.urlEndpoint,this.payload);
        
        this.token.setDefinitiveAccess(definitive_token);
    }

    public TokenModel getToken(){
        
        this.sendRequest();
        return this.token;
    }


}
