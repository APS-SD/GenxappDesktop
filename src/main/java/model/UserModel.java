package model;

public class UserModel implements Model {    
    private String username;
    private String password;
	private String first_name;
    private String last_name;
    private String email;        

    public UserModel() {
    	this("", "", "", "", "");
    }
	
    public UserModel(String username, String password, String firstName, String lastName, String email) {
		this.username = username;
		this.password = password;
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String lastName) {
		this.last_name = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CredentialLoginModel [username=" + this.getUsername() + ", password=" + this.getPassword() + "]";
	}

}
