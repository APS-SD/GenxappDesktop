/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import model.UserLoginModel;
import model.TokenModel;

public class Session {
    
    static Session instance; 
    private  UserLoginModel user = null;
    private  TokenModel token = null;
        
    public static Session getSession() {
    	if (instance == null) {
    		instance = new Session();    		
    	}
    	return instance;
    }
    
    public static void setSession(UserLoginModel user, TokenModel token) {
    	
    	Session s = Session.getSession();
        s.setToken(token);
    	s.setUser(user);
        
    }

    public UserLoginModel getUser() {
            return user;
    }

    public void setUser(UserLoginModel user) {
            this.user = user;
    }

    public TokenModel getToken() {
            return token;
    }

    public void setToken(TokenModel token) {
            this.token = token;
    }

    
    
}
