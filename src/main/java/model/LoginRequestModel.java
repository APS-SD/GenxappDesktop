package model;

public interface LoginRequestModel {
	public LoginRequestModel assembleLoginRequest (UserLoginModel user);
	public LoginRequestModel sendLoginRequest() throws Exception;
	public TokenModel getToken();
}
