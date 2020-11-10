package controller;


import java.util.List;

import domain.Response;
import domain.Session;
import domain.miRNARequest;
import domain.exceptions.SessionExpiredException;
import helpers.userHelpers.UserFactory;
import model.TargetScanModel;
import serializer.TargetScanSerializer;

public class miRNAController{
    private final miRNARequest request;
    private TargetScanModel response;
    private String txtResponse;
    private String error;

    public miRNAController() {	
        this.request = new miRNARequest();
    }

   
	public String getTxtResponse() {
        return txtResponse;
    }

    public void setTxtResponse(String txtResponse) {
        this.txtResponse = txtResponse;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isSession() throws SessionExpiredException{
        // validar se a seção está ativa
        if(true){
            throw new SessionExpiredException();
        }
        
        return true;
    }
    

    public List<TargetScanModel> retrieveTargetScan() {

        Response response = this.request.retrieveTargetScan();
        System.out.println(response.getContent());
        
        if (response.getStatus_code() == 200){
        	
            List<TargetScanModel> lista = new TargetScanSerializer().getAllasList(response.getContent());
            
            return lista;
            
            
            //return true;
        }else{
            //return false;
        	return null;
        }
		
    }


}
