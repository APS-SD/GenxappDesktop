package helpers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HTTPClient {

    private final String USER_AGENT = "Mozilla/5.0";
    public HttpURLConnection request;

    public HTTPClient() {

    }

    public HTTPClient(HttpURLConnection request) {
        this.request = request;
    }

    
    public String sendGet(String url, String token) {

        try {
           URL obj = new URL(url);
           
           this.request = (HttpURLConnection) obj.openConnection();

           // declarações de cabeçalho
           this.request.setRequestMethod("GET");
           this.request.setRequestProperty("User-Agent", USER_AGENT);
                 
           String authHeaderValue = "Bearer " + new String(token);    // cabeçalho de com autenticação

           this.request.setRequestProperty("Authorization", authHeaderValue);
           
           this.request.connect();
           
           return ProcessRequest();
       
        } catch (Exception e) {
            return "{Nenhuma String}";
        } finally {
        	this.request.disconnect();
        }

    }

    private String ProcessRequest() {
    	
    	int statusCode = 0;
		try {
			statusCode = this.request.getResponseCode();
			
		    return readResponse(this.request);
			    
		} catch (IOException e) {
			  return Integer.toString(statusCode);
		}
  
	}
    
    public String sendGet(String url) {

        try {
           URL obj = new URL(url);
           this.request = (HttpURLConnection) obj.openConnection();

           // declarações de cabeçalho
           this.request.setRequestMethod("GET");
           this.request.setRequestProperty("User-Agent", USER_AGENT);
           this.request.connect();
            
           return readResponse(this.request);

        } catch (Exception e) {
            return "{Nenhuma String}";
        } finally {
        	this.request.disconnect();
        }

    }

    public String sendPost(String url, String json) {

        try {
            // Cria um objeto HttpURLConnection:
            this.request = (HttpURLConnection) new URL(url).openConnection();

            try {
                // Define que a conexão pode enviar informações e obtê-las de volta:
                this.request.setDoOutput(true);
                this.request.setDoInput(true);

                // Define o content-type:
                this.request.setRequestProperty("Content-Type", "application/json");

                // Define o método da requisição:
                this.request.setRequestMethod("POST");

                // Conecta na URL:
                this.request.connect();

                // Escreve o objeto JSON usando o OutputStream da requisição:
                try (OutputStream outputStream = this.request.getOutputStream()) {
                    outputStream.write(json.getBytes("UTF-8"));
                }

                // Caso você queira usar o código HTTP para fazer alguma coisa, descomente esta linha.
                return readResponse(this.request);
            } finally {
                this.request.disconnect();
            }
        } catch (IOException ex) {
            System.out.println("");
        }

        return "Erro";
    }

    private String readResponse(HttpURLConnection request) throws IOException {
        ByteArrayOutputStream os;
        
        try (InputStream is = request.getInputStream()) {
        	
            os = new ByteArrayOutputStream();
            int b;
            while ((b = is.read()) != -1) {
                os.write(b);
            }
        }
        return new String(os.toByteArray());
    }

    
    
}
