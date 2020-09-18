/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import com.google.gson.Gson;
import helpers.HTTPClient;
import model.UserModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TokenModel;
import org.json.JSONException;
import org.json.JSONObject;
import serializer.TokenSerializer;
import serializer.UserSerializer;

/**
 *
 * @author iedash
 */
public class App {

    public static void main(String[] args) {
        App.String2Json();
    }

    public static void getAllUsers() {
        HTTPClient http = new HTTPClient();

        JSONObject json = new JSONObject();
        try {
            json.put("username", "br");
            json.put("password", "br");

            String response_str;

            response_str = http.sendGet("https://genxapp.herokuapp.com/api/v1/users/?format=json");

            System.out.println(response_str);
        } catch (JSONException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void String2Json() {

        // --- transformando em Objeto Java --- //
        Gson gson = new Gson(); // conversor
        UserModel user = new UserModel("br", "br");

        String json = gson.toJson(user);

        System.out.println(json);
    }

    public static void Json2Login() {

        //  url do EndPoint
        String url = "https://genxapp.herokuapp.com/api/v1/login/?format=json";

        // Cliente abstraído para utilizar os verbos HTTP
        HTTPClient request = new HTTPClient();

        // Serialização de Objetos
        UserModel um = new UserModel("br", "br");
        String json = UserSerializer.toStringJson(um);

        //  Deserialização de objetos
        String response = request.sendPost(url,json);
        TokenModel tkm  = TokenSerializer.stringJson2Object(response);
        
        System.out.println(tkm);
    }
}
