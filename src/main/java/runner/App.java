/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runner;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.ControllerGateway;
import controller.UserController;

import helpers.HTTPClient;
import model.CredentialLoginModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TokenModel;
import model.UserModel;
import org.json.JSONException;
import org.json.JSONObject;
import serializer.TokenSerializer;
import serializer.UserSerializer;

public class App {

    public static void main(String[] args) {
    	

    	/*
        
        
        // Consumo Token
    	HTTPClient c = new HTTPClient();
    	
    	Gson jsonConversor = new Gson();
    	
    	CredentialLoginModel m = new CredentialLoginModel("br", "br");
    	
    	String json = jsonConversor.toJson(m);
    	
    	String response = c.sendPost("https://genxapp.herokuapp.com/api/v1/login/?format=json", json);
    		
    	
    	// Refresh Tokenb
    	TokenModel tm = jsonConversor.fromJson(response, TokenModel.class);
    	
    	JSONObject jo = new JSONObject();
    	
    	try {
			String payload = jo.put("refresh", tm.getRefresh()).toString();
		
			response = c.sendPost("https://genxapp.herokuapp.com/api/v1/login/refresh/?format=json", payload);
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
    	
    	TokenModel tokenAbsoluto  = jsonConversor.fromJson(response, TokenModel.class);
    	
    	// System.out.println(tokenAbsoluto);
    	// System.out.println(response);
    	
    	String responseUser = c.sendGet("https://genxapp.herokuapp.com/api/v1/users_auth/?format=json", tokenAbsoluto.getAccess());
    	
    	try {
			JSONObject jo2 = new JSONObject(responseUser);
			
			String rstring = jo2.getString("results");
			System.out.println(rstring);
			
			Type t = new TypeToken<ArrayList<CredentialLoginModel>>() {}.getType();
			
			ArrayList<CredentialLoginModel> lum = jsonConversor.fromJson(rstring, t);
			
			System.out.println(lum);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        */
        
        ControllerGateway cg =  new ControllerGateway();
        UserController uc = new UserController();
        uc.create("bre", "bre", "breno@breno.com.br", "bern", "Bern");
        
        
        boolean result = cg.logon("bre", "bre");
        
        if(result){
            
          System.out.println(uc.retrieve());
          System.out.println(uc.update("bre", "bre", "br@br.com.br", "br", "br"));
          System.out.println(uc.retrieve());
          System.out.println(uc.delete());
            
        }
        
    }
    
    public static void name() {
    	 App.object2Json();
         App.array2Json();
         App.string2Json();
         
         
	}
   
    public static void createUser() {
    	
    	HTTPClient http = new HTTPClient();
    	TokenModel token = App.Json2Login(false);
    	
        
        UserModel m = new UserModel("bern", "bern", "bern", "Bern","breno@breno.com.br");
        UserSerializer us = new UserSerializer();
      
        String payload =us.toStringJson(m);
        
        try {
            String response_str = http.sendPost("https://genxapp.herokuapp.com/api/v1/user/?format=json", payload,token.getAccess());
            
            System.out.println(response_str);
            
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void ConsumingWithoutToken() {
    	Gson gson = new Gson();
    	
    	HTTPClient http = new HTTPClient();
          	
        try {
            String response_str;

            response_str = http.sendGet("https://genxapp.herokuapp.com/api/v1/users/?format=json");
            
            JSONObject jsonObj = new JSONObject(response_str);
            
            String json =  jsonObj.getString("results");
            
            Type tipoLista = new TypeToken<ArrayList<CredentialLoginModel>>() {}.getType();
            
            ArrayList<CredentialLoginModel> lista = gson.fromJson(json, tipoLista);
    		
    		for(CredentialLoginModel um: lista ) {
    			System.out.println(um.getUsername());
    		}
   
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void jsonOBJ() {
        JSONObject json = new JSONObject();
        try {
			json.put("username", "br");
			json.put("password", "br");
			
		System.out.println(json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static void object2Json() {
        // --- transformando em Objeto Json--- //
        Gson gson = new Gson(); // conversor
        
        CredentialLoginModel user = new CredentialLoginModel("br", "br");

        String json = gson.toJson(user);

        System.out.println(json);
    }

    public static void array2Json() {
    	// lista de texto //
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("breno@gmail.com");
		lista.add("bernar@teste.com");
		lista.add("javeiro@php.com");
		
		// --- convertendo para json --- //
		Gson gson = new Gson();
		String json = gson.toJson(lista);
		
		// --- exibindo json --- //
		System.out.println(json);
	}
    				
    public static void stringArray2Json() {
    	String json = "[\"victormenegusso@gmail.com\",\"teste@teste.com\",\"javeiro@php.com\"]";
		
		// --- convertendo para json --- //
		Gson gson = new Gson();
		
		Type tipoLista = new TypeToken<ArrayList<String>>() {}.getType();
		ArrayList<String> lista = gson.fromJson(json, tipoLista);
		
		// --- exibindo json --- //
		for(String item : lista)
		{
			System.out.println(item);
		}
	}
    
    public static void string2Json() {
    	String json = "{\"username\":\"Victor\",\"password\":\"victormenegusso@gmail.com\"}";
		
		// --- transformando em Objeto Java --- //
		Gson gson = new Gson(); 
		
		CredentialLoginModel objusr = gson.fromJson(json, CredentialLoginModel.class);
		
		System.out.println(objusr);
	}
    
    public static TokenModel Json2Login(Boolean print) {

        //  url do EndPoint
        String url = "https://genxapp.herokuapp.com/api/v1/login/?format=json";

        // Cliente abstraído para utilizar os verbos HTTP
        HTTPClient request = new HTTPClient();

        // Serialização de Objetos
        CredentialLoginModel um = new CredentialLoginModel("br", "br");
        String json = new UserSerializer().toStringJson(um);

        //  Deserialização de objetos
        String response = request.sendPost(url,json);
        TokenModel tkm  = new TokenSerializer().Json2Object(response);
        
        if(print) {
        	System.out.println(tkm);
        }
        
        return tkm;
    }
}
