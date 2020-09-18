/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializer;

import com.google.gson.Gson;
import model.TokenModel;

/**
 *
 * @author iedash
 */
public class TokenSerializer {
    
    public static TokenModel stringJson2Object(String stringJson) {
        // conversor
        Gson gson = new Gson();
        return gson.fromJson(stringJson, TokenModel.class);
    }
    
    
}
