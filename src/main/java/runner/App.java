/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runner;


import controller.ControllerGateway;
import controller.UserController;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.LoginForm;


public class App {

    public static void main(String[] args) {
    	
        new LoginForm().setVisible(true);
        
    }
    
    public static void crud(){
       
        ControllerGateway cg =  new ControllerGateway();
        UserController uc = new UserController();
        
        try {
            boolean s = uc.create("bo", "bo", "breno@breno.com.br", "bern", "Bern");
            System.out.println(s);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean result = cg.logon("bo", "bo");
        
        if(result){
           try {
                System.out.println(uc.retrieve());
                System.out.println(uc.update("bo", "bo", "br@br.com.br", "br", "br"));
                System.out.println(uc.delete());
            } catch (Exception e) {
               try {
                   System.out.println(uc.delete());
               } catch (Exception ex) {
                   Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
               }
                System.out.println(e);
            }
        }
         
    }
   
}
