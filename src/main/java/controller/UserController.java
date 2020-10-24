package controller;

import domain.Response;
import domain.UserRequest;
import helpers.UserFactory;
import model.UserModel;

public class UserController{
	private UserRequest request;
	
	
	public Response create(String... args){
		UserModel user = null; 
		
		try {
			user = UserFactory.create(args);
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		return null;		
	}

	public UserModel update(UserModel user) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserModel retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserModel delete() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
