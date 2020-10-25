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

        
	public String createUser(UserModel user) {
            String strUser = this.serializer.toStringJson(user);
            String response = "";
            
            try {
                // teria que ser tratado aqui
                response = this.client.sendPost(Endpoint.getUser(), strUser); 
                
            } catch (Exception e) {
                // colocar exception aqui
            }

            return response;
	}
	
	public UserModel retrievetUser() {
            
            String acessToken = this.session.getToken().getAccess();
            UserModel user = null;
            
            try {
               
               String response = this.client.sendGet(Endpoint.getUserAtuh(), acessToken);
               user = this.serializer.Json2Object(response);
               
            } catch (Exception e) {
                System.out.println("Erro no Retorno do Usuário");
            }
            
            return user;
	}
	
	public UserModel updateUser(UserModel user) {
            
            String acessToken = this.session.getToken().getAccess();
            String strUser = this.serializer.toStringJson(user);
            
            try {
                
               String response = this.client.sendPut(Endpoint.getUserAtuh(), strUser,acessToken);
               user = this.serializer.Json2Object(response);
               
            } catch (Exception e) {
                System.out.println("Erro ao alterar o Usuário");
            }
            
            return user;
	}
	
	public String deleteUser() {
            String acessToken = this.session.getToken().getAccess();
            String response = "";
            
            try {
               
               response = this.client.sendDelete(Endpoint.getUserAtuh(), acessToken);
               
            } catch (Exception e) {
                System.out.println("Erro no Deletar o Usuário");
            }
            
            return response;
	}
}
