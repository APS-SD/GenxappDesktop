/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UserController;

/**
 *
 * @author LC_Note
 */
public class LoginView {
    
    public static void callLogin(String login, String senha){
        try {
            UserController lg = new UserController();
            lg.Logon(login,senha);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
    } 
}
