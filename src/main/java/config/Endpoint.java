package config;

public abstract class Endpoint {
	private static final String rootURL = "https://genxapp.herokuapp.com/api/v1/";
	
	public static String getAuthentication() {		
		return rootURL + "login/?format=json";
	}
	
	public static String getRefresh() {		
		return rootURL + "login/refresh/?format=json";
	}
        
        public static String getUser(){
            return rootURL + "user/?format=json";
        }
        
        public static String getUserAtuh(){
            return rootURL + "user_auth/?format=json";
        }
        
        public static String getMIRDB() {
        	return rootURL + "mirdb/?format=json";
        }
        
        public static String getTargetScan() {
        	return rootURL + "tgscan/?format=json";
        }
}
