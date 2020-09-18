/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializer;

import com.google.gson.Gson;
import model.TokenModel;
import model.UserModel;

/**
 *
 * @author iedash
 */
public class UserSerializer {

    public static String toStringJson(UserModel user) {
        // --- transformando em Objeto Java --- //
        Gson gson = new Gson(); // conversor

        return gson.toJson(user);
    }

    

}
