/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializer;

import java.util.List;

import com.google.gson.Gson;
import model.UserLoginModel;

public class UserSerializer implements Serializer {

	@SuppressWarnings("hiding")
	@Override
    public <UserLoginModel> String toStringJson(UserLoginModel userModel) {
        
        Gson gson = new Gson();
        return gson.toJson(userModel);
    }
	
	@Override
	public Object Json2Object(String stringJson) {

		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <UserLoginModel> List<UserLoginModel> getAll() {

		return null;
	}

}
