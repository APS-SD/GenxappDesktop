package controller;

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

	public static void performLogin(CredentialLoginModel user) throws Exception{				
        LoginPerformer.performLogin(user, true);
	}
        
	public static void performLogin(CredentialLoginModel user, boolean kind) throws Exception{		
	
	    TokenModel token = LoginPerformer.requestPrimaryLogin(user);
	
	    if (kind){
	        token = LoginPerformer.requestDefinitiveLogin(token);		
	    }
	
	    Session.setSession(user, token);	                
	}
}
