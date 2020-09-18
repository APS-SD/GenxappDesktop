/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializer;

import java.util.List;

import com.google.gson.Gson;
import model.TokenModel;

public class TokenSerializer implements Serializer {
	
	@Override
    public TokenModel Json2Object(String stringJson) {
        Gson gson = new Gson();
        return gson.fromJson(stringJson, TokenModel.class);
    }

	@SuppressWarnings("hiding")
	@Override
	public <TokenModel> String toStringJson(TokenModel objectModel) {
		
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <TokenModel> List<TokenModel> getAll() {
		
		return null;
	}
	    
    
}
