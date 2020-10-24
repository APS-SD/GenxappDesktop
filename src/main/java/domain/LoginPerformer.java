package domain;

import helpers.LoginRequest;
import helpers.RefreshRequest;
import model.TokenModel;
import model.UserLoginModel;


public abstract class LoginPerformer {
	
	public static TokenModel requestPrimaryLogin(UserLoginModel user) throws Exception {//Change to loginException
            return new LoginRequest(user).getToken();		
	}
	
	public static TokenModel requestDefinitiveLogin(TokenModel token)throws Exception{
            return new RefreshRequest(token).getToken();
	}

	public static void performLogin(UserLoginModel user) throws Exception{				
            LoginPerformer.performLogin(user, true);
	}
        
        public static void performLogin(UserLoginModel user, boolean kind) throws Exception{		
		
            TokenModel token = LoginPerformer.requestPrimaryLogin(user);

            if (kind){
                token = LoginPerformer.requestDefinitiveLogin(token);		
            }

            Session.setSession(user, token);	
                
	}
}
