package helpers;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import config.Endpoint;
import model.RefreshRequestModel;
import model.RequestModel;
import model.TokenModel;

public class RefreshRequest extends RequestModel implements RefreshRequestModel{

	private String payload;
	
	public RefreshRequest(TokenModel token) {
		super();
		super.token = token;
		super.JsonConversor = new Gson();
		super.client = new HTTPClient();
		
	}	

	@Override
	public RefreshRequestModel assembleRefreshRequest(TokenModel token) throws JSONException {
		urlEndpoint = Endpoint.getRefresh();    	
		
    	JSONObject jo = new JSONObject();
        
		payload = jo.put("refresh", token.getRefresh()).toString();
					   		
		return this;
	}

	@Override
	public RefreshRequestModel sendRefreshRequest() {
		super.token.setDefinitiveAccess(client
				.sendPost(urlEndpoint
							,payload)
			);
			
		return this;
	}

	@Override
	public TokenModel getToken() {
		return super.token;
	}

}
