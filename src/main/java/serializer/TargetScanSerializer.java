/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.TargetScanModel;
import model.miRDBModel;


public class TargetScanSerializer implements Serializer {

	@SuppressWarnings("hiding")
	@Override
    public <TargetScanModel> String toStringJson(TargetScanModel userModel) {
        
        Gson gson = new Gson();
        return gson.toJson(userModel);
    }
	
    
    public TargetScanModel Json2Object(String stringJson) {
        Gson gson = new Gson();
        return gson.fromJson(stringJson, TargetScanModel.class);
    }

	@SuppressWarnings("hiding")
	@Override
	public <TargetScanModel> List<TargetScanModel> getAll() {

		return null;
	}

	
	
	@SuppressWarnings({ "hiding", "unchecked" })
	public <TargetScanModel> List<TargetScanModel> getAllasList(String json) {
		
		
		String jsonResults=""; 
		
		Gson gson = new Gson();
		
		try {
			JSONObject jsonStr = new JSONObject(json);
			jsonResults = jsonStr.get("results").toString();
			jsonResults = jsonResults.replace("/", "+");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Type collectionType = new TypeToken<List<TargetScanModel>>(){}.getType();
		List<TargetScanModel> tgs = gson.fromJson(jsonResults , collectionType);
	
		List<TargetScanModel> lResult = new ArrayList<>();
		
		for(Object tg: tgs) {
			 TargetScanModel t = (TargetScanModel) this.Json2Object(tg.toString());
			 lResult.add(t);
			 
		}
		
		return lResult;
		
	}
}
