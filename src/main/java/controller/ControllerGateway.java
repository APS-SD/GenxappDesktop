package controller;

import domain.LoginPerformer;
import helpers.userHelpers.UserBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CredentialLoginModel;
import model.UserModel;

public class ControllerGateway {

	public boolean logon(String username, String password){
            CredentialLoginModel clm = new  CredentialLoginModel(username, password);
            
            try {
                LoginPerformer.performLogin(clm);
                return true;
            } catch (Exception ex) {
                Logger.getLogger(ControllerGateway.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            
        }
	
	
}
