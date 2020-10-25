package controller;

import com.google.gson.JsonObject;
import domain.Response;
import domain.UserRequest;
import helpers.UserFactory;
import model.UserModel;

public class UserController{
	private final UserRequest request;
	
	public UserController() {
		
		this.request = new UserRequest();
	}

	public String create(String username, String password, String email,String firstName, String lastName ){

		UserModel user = null; 
		
		try {
		    user = UserFactory.create(username, password,  email, firstName, lastName );
                    
		} catch (Exception e) {
		    System.err.println("usuario nao criado");
		}
		
		String response = this.request.createUser(user);
		
                return response;
	}

	public UserModel update(String username, String password, String email,String firstName, String lastName ) {
		UserModel user = null; 
		
		try {
		    user = UserFactory.create(username, password,  email, firstName, lastName );
                    
		} catch (Exception e) {
		    System.err.println("usuario nao criado");
		}
		
		UserModel response = this.request.updateUser(user);
		
                return response;
	}

	public UserModel retrieve() {
             return this.request.retrievetUser();
	}

	public String delete() {
            return this.request.deleteUser();
	}
	

}
