package controller;


import domain.Response;
import domain.UserRequest;
import helpers.userHelpers.UserFactory;
import model.UserModel;
import serializer.UserSerializer;

public class UserController{
	private final UserRequest request;
        
	public UserController() {	
            this.request = new UserRequest();
	}

	public String create(String username, String password, String email,String firstName, String lastName ) throws Exception{

            UserModel user = UserFactory.create(username, password,  email, firstName, lastName );

            Response response = this.request.createUser(user);

            if (response.getStatus_code() == 201){
                return response.getContent();
            }else{
                throw new Exception(response.getContent());
            }
                
	}

	public UserModel update(String username, String password, String email,String firstName, String lastName ) throws Exception {
		
            UserModel user = UserFactory.create(username, password,  email, firstName, lastName );

            Response response = this.request.updateUser(user);
            
            if (response.getStatus_code() == 200){
                return new UserSerializer().Json2Object(response.getContent());
            }else{
                throw new Exception(response.getContent());
            }
	}

	public UserModel retrieve() throws Exception {
           
            Response response = this.request.retrievetUser();
            
            if (response.getStatus_code() == 200){
                return new UserSerializer().Json2Object(response.getContent());
            }else{
                throw new Exception(response.getContent());
            }
	}

	public String delete() throws Exception {
            
            Response response = this.request.deleteUser();
            
            if (response.getStatus_code() == 200){
                return response.getContent();
            }else{
                throw new Exception(response.getContent());
            }
            
	}
	
        
        public String verify(){
            return "";
        }
        
        public UserModel responseObject(){
            return null;
        }
}
