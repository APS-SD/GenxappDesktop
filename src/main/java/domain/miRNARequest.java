package domain;

import config.Endpoint;
import model.RequestModel;
import model.UserModel;
import serializer.UserSerializer;

public class miRNARequest extends RequestModel{
    
        private final UserSerializer serializer;
        private final Session session = Session.getSession();
        
        public miRNARequest() {
            super();
            this.serializer = new UserSerializer();
        }

        
	
	public Response retrievetmiRDB() {
            
            String acessToken = this.session.getToken().getAccess();
            
            return this.client.sendGet(Endpoint.getMIRDB(), acessToken);
            
	}
	
	public Response retrieveTargetScan() {
        
        String acessToken = this.session.getToken().getAccess();
        
        return this.client.sendGet(Endpoint.getTargetScan(), acessToken);
	      
	}
	
}
