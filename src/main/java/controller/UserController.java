package controller;


import domain.Response;
import domain.Session;
import domain.UserRequest;
import domain.exceptions.SessionExpiredException;
import helpers.userHelpers.UserFactory;
import model.UserModel;
import serializer.UserSerializer;

public class UserController{
    private final UserRequest request;
    private UserModel userResponse;
    private String txtResponse;
    private String error;

    public UserController() {	
        this.request = new UserRequest();
    }

    public UserModel getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserModel userResponse) {
        this.userResponse = userResponse;
    }

    public String getTxtResponse() {
        return txtResponse;
    }

    public void setTxtResponse(String txtResponse) {
        this.txtResponse = txtResponse;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isSession() throws SessionExpiredException{
        // validar se a seção está ativa
        if(true){
            throw new SessionExpiredException();
        }
        
        return true;
    }
    
    public boolean create(String username, String password, String email,String firstName, String lastName ){

        UserModel user = UserFactory.create(username, password,  email, firstName, lastName);

        Response response = this.request.createUser(user);

        if (response.getStatus_code() == 201){
            this.txtResponse = response.getContent();
            return true;
        }else{
            this.error = response.getContent();
            return false;
        }

    }

    public boolean update(String username, String password, String email,String firstName, String lastName ){

        UserModel user = UserFactory.create(username, password,  email, firstName, lastName );

        Response response = this.request.updateUser(user);

        if (response.getStatus_code() == 200){
            this.userResponse = new UserSerializer().Json2Object(response.getContent());
            return true;
        }else{
            this.error = response.getContent();
            return false;
        }
    }

    public boolean retrieve() {

        Response response = this.request.retrievetUser();

        if (response.getStatus_code() == 200){
            this.userResponse = new UserSerializer().Json2Object(response.getContent());
            return true;
        }else{
            return false;
        }
    }

    public boolean delete() {

        Response response = this.request.deleteUser();

        if (response.getStatus_code() == 200){
            this.txtResponse= response.getContent();
            return true;
        }else{
            this.error =  response.getContent();
            return false;
        }

    }

}
