package model;

public interface LoginRequestModel {
	public LoginRequestModel assembleLoginRequest (UserModel user);
	public LoginRequestModel sendLoginRequest() throws Exception;
	public TokenModel getToken();
}
