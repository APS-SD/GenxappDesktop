package model;

import config.Endpoint;
import helpers.HTTPClient;
import com.google.gson.Gson;

public abstract class RequestModel {
	protected String urlEndpoint;
	protected HTTPClient client;
	protected Gson JsonConversor;
	protected TokenModel token;	
}
