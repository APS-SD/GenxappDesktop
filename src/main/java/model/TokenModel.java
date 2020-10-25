/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class TokenModel implements Model {

           
    public String access;
    public String refresh;
    
    

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getRefresh() {
        return refresh;
    }
    
    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }
        
    @Override
    public String toString() {
        return "TokenModel{" + "access=" + access + ", refresh=" + refresh +'}';
    }

    
}
