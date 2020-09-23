package config;

public abstract class Endpoint {
	private static final String rootURL = "https://genxapp.herokuapp.com/api/v1/";
	
	public static String getAuthentication() {		
		return rootURL + "login/?format=json";
	}
}
