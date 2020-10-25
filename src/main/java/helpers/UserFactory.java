package helpers;

import model.UserModel;

public class UserFactory {
	public static UserModel create(String... userArgs) throws Exception {
		if (userArgs.length < 4) {
			throw new Exception("teste");
		}
		
		UserBuilder builder = new UserBuilder();
		builder.setUserName(userArgs[0]);
		builder.setPassword(userArgs[1]);
		builder.setEmail(userArgs[2]);
		builder.setFirstName(userArgs[3]);
		
		if (userArgs.length > 4) {
			builder.setLastName(userArgs[4]);
		}
		 
		return builder.get();
	}
        
        public static UserModel create(String username, String password, String email,String firstName, String lastName ){
                UserBuilder builder = new UserBuilder();
		builder.setUserName(username);
		builder.setPassword(password);
		builder.setEmail(email);
		builder.setFirstName(firstName);
		builder.setLastName(lastName);
	
		return builder.get();
        }
}
