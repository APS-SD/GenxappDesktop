package domain;

import model.TokenModel;
import domain.LoginRequest;
import domain.RefreshRequest;
import domain.Session;
import model.CredentialLoginModel;


public abstract class LoginPerformer {
	
	public static TokenModel requestPrimaryLogin(CredentialLoginModel user) throws Exception {//Change to loginException
        
            LoginRequest processor = new LoginRequest();
            processor.assembleLogingRequest(user);
		
            return processor.getToken();		
	}
	
	public static TokenModel requestDefinitiveLogin(TokenModel token)throws Exception{
        
            RefreshRequest processor =  new RefreshRequest();
            processor.assembleToken(token);
        
            return processor.getToken();
	}

        
	public static boolean performLogin(CredentialLoginModel user){				
            return LoginPerformer.performLogin(user, true);
	}
        
	public static boolean performLogin(CredentialLoginModel user, boolean kind) {		
	
            try {
                TokenModel token = LoginPerformer.requestPrimaryLogin(user);
	
                if (kind){
                    token = LoginPerformer.requestDefinitiveLogin(token);		
                }

                Session.setSession(user, token);	                
                
                return true;
            } catch (Exception e) {
                return false;
            }

	    
	}
}
