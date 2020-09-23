package model;

public interface LoginRequestModel {
	public LoginRequestModel assembleLoginRequest (UserModel user);
	public TokenModel sendLoginRequest() throws Exception;
}
