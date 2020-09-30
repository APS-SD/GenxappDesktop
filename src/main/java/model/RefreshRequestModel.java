package model;

import org.json.JSONException;

import model.TokenModel;

public interface RefreshRequestModel {
	public RefreshRequestModel assembleRefreshRequest(TokenModel token) throws JSONException;
	public RefreshRequestModel sendRefreshRequest();
	public TokenModel getToken();
}
