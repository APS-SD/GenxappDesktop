package domain;

import config.Endpoint;
import model.RequestModel;
import model.UserModel;
import serializer.UserSerializer;

public class UserRequest extends RequestModel{
    
        private final UserSerializer serializer;
        private final Session session = Session.getSession();
        
        public UserRequest() {
            super();
            this.serializer = new UserSerializer();
        }

        
	public Response createUser(UserModel user) {
            
            String strUser = this.serializer.toStringJson(user);
            
            return this.client.sendPost(Endpoint.getUser(), strUser); 
	}
	
	public Response retrievetUser() {
            
            String acessToken = this.session.getToken().getAccess();
            
            return this.client.sendGet(Endpoint.getUserAtuh(), acessToken);
            
	}
	
	public Response updateUser(UserModel user) {
            
            String acessToken = this.session.getToken().getAccess();
            String strUser = this.serializer.toStringJson(user);
             
            return this.client.sendPut(Endpoint.getUserAtuh(), strUser,acessToken);
	}
	
	public Response deleteUser() {
          
            String acessToken = this.session.getToken().getAccess();
            
            return this.client.sendDelete(Endpoint.getUserAtuh(), acessToken);
	}
}
