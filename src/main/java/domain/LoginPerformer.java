package domain;

import model.TokenModel;
import model.CredentialLoginModel;


public abstract class LoginPerformer {
	
	public static TokenModel requestPrimaryLogin(CredentialLoginModel user) throws Exception {//Change to loginException
        
            LoginRequest processor = new LoginRequest();
            processor.assembleLogingRequest(user);
            
            boolean isSuccess = processor.assembleToken();
            
            if(isSuccess){
                return processor.getToken();		
            }else{
                throw new Exception("Erro ao logar");
            }
	}
	
	public static TokenModel requestDefinitiveLogin(TokenModel token)throws Exception{
        
            RefreshRequest processor =  new RefreshRequest();
            
            boolean isSuccess = processor.assembleToken(token);
        
            if(isSuccess){
                return processor.getToken();
            }else{
                throw new Exception("Erro no login secundário");
            }
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
