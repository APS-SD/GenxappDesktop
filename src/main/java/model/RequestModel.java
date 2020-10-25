package model;

import config.Endpoint;
import helpers.HTTPClient;
import com.google.gson.Gson;

public abstract class RequestModel<T> {
	protected String urlEndpoint;
	protected HTTPClient client;
	protected Gson JsonConversor;
	protected TokenModel token;	

    public RequestModel() {
    
        this.client = new HTTPClient();
        this.JsonConversor = new Gson();
        
    }
        
       
}
