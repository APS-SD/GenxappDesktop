package helpers.userHelpers;

import model.UserModel;

public class UserBuilder {
	private UserModel user;

    public UserBuilder() {
        this.user = new UserModel();
    }

	public UserBuilder setUserName(String userName) {
		this.user.setUsername(userName);
		return this;
	}
	
	public UserBuilder setPassword(String password) {
		this.user.setPassword(password);
		return this;
	}
	
	public UserBuilder setFirstName(String firstName) {
		this.user.setFirstName(firstName);
		return this;
	}
	
	public UserBuilder setLastName(String lastName) {
		this.user.setLastName(lastName);
		return this;
	}
	
	public UserBuilder setEmail(String email) {
		this.user.setEmail(email);
		return this;
	}
	
	public UserModel get() {
		return this.user;		
	}
	
	
}
