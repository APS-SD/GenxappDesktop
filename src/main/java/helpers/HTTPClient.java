package helpers;

import domain.Response;
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

    
    public Response sendGet(String url, String token) {

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
       
        } catch (IOException e) {
            return new Response(404);
        } finally {
            this.request.disconnect();
        }

    }

    private Response ProcessRequest() {
    	Response response = new Response();
        
        int statusCode = 404;
        response.setStatus_code(statusCode);
    	
        try {
                statusCode = this.request.getResponseCode();
                String content = readResponse(this.request);

                response.setStatus_code(statusCode);
                response.setContent(content);
                
        } catch (IOException e) {
                 
        }

        return response;
    }
    
    public Response sendGet(String url) {

        try {
           URL obj = new URL(url);
           this.request = (HttpURLConnection) obj.openConnection();

           // declarações de cabeçalho
           this.request.setRequestMethod("GET");
           this.request.setRequestProperty("User-Agent", USER_AGENT);
           this.request.connect();
            
           
           return new Response(this.request.getResponseCode(), readResponse(this.request));
                
        } catch (Exception e) {
            return new Response(404);
        } finally {
            this.request.disconnect();
        }

    }

    public Response sendPost(String url, String json) {

            try {
                
                // Cria um objeto HttpURLConnection:
                this.request = (HttpURLConnection) new URL(url).openConnection();

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
                
                return new Response(this.request.getResponseCode(),readResponse(this.request));
            } catch (IOException ex) {
                return new Response(404);
            }   finally {
                
                this.request.disconnect();
            }
        
    }
    
    public Response sendPost(String url, String json, String token) {

        try {
            // Cria um objeto HttpURLConnection:
            this.request = (HttpURLConnection) new URL(url).openConnection();

            // Define que a conexão pode enviar informações e obtê-las de volta:
            this.request.setDoOutput(true);
            this.request.setDoInput(true);

            // Define o content-type:
            this.request.setRequestProperty("Content-Type", "application/json");

            // Define o método da requisição:
            this.request.setRequestMethod("POST");

            String authHeaderValue = "Bearer " + new String(token);    // cabeçalho de com autenticação

            this.request.setRequestProperty("Authorization", authHeaderValue);   

            // Conecta na URL:
            this.request.connect();

            // Escreve o objeto JSON usando o OutputStream da requisição:
            try (OutputStream outputStream = this.request.getOutputStream()) {
                outputStream.write(json.getBytes("UTF-8"));
            }

            // Caso você queira usar o código HTTP para fazer alguma coisa, descomente esta linha.
            return new Response(this.request.getResponseCode(),readResponse(this.request));
        } catch (IOException ex) {
            return new Response(404);
        }  

    }

    public Response sendPut(String url, String json, String token) {

            try {
                // Cria um objeto HttpURLConnection:
                this.request = (HttpURLConnection) new URL(url).openConnection();

                // Define que a conexão pode enviar informações e obtê-las de volta:
                this.request.setDoOutput(true);
                this.request.setDoInput(true);

                // Define o content-type:
                this.request.setRequestProperty("Content-Type", "application/json");

                // Define o método da requisição:
                this.request.setRequestMethod("PUT");

                String authHeaderValue = "Bearer " + new String(token);    // cabeçalho de com autenticação

                this.request.setRequestProperty("Authorization", authHeaderValue);   
                
                // Conecta na URL:
                this.request.connect();

                // Escreve o objeto JSON usando o OutputStream da requisição:
                try (OutputStream outputStream = this.request.getOutputStream()) {
                    outputStream.write(json.getBytes("UTF-8"));
                }

                // Caso você queira usar o código HTTP para fazer alguma coisa, descomente esta linha.
               return new Response(this.request.getResponseCode(),readResponse(this.request));
            } catch (IOException ex) {
                return new Response(404);
            } finally {
                this.request.disconnect();
            }
        
    }
    
    public Response sendDelete(String url, String token) {

            try {
                // Cria um objeto HttpURLConnection:
                this.request = (HttpURLConnection) new URL(url).openConnection();
                // Define que a conexão pode enviar informações e obtê-las de volta:
                this.request.setDoOutput(true);
                this.request.setDoInput(true);

                // Define o content-type:
                this.request.setRequestProperty("Content-Type", "application/json");

                // Define o método da requisição:
                this.request.setRequestMethod("DELETE");

                String authHeaderValue = "Bearer " + new String(token);    // cabeçalho de com autenticação

                this.request.setRequestProperty("Authorization", authHeaderValue);   
                
                // Conecta na URL:
                this.request.connect();

                // Caso você queira usar o código HTTP para fazer alguma coisa, descomente esta linha.
                return new Response(this.request.getResponseCode(),readResponse(this.request));
            } catch (IOException ex) {
                return new Response(404);
            }  finally {
                this.request.disconnect();
            }
        
    }
    
    public Response sendDelete(String url, String json, String token) {
        
            try {                
                // Cria um objeto HttpURLConnection:
                this.request = (HttpURLConnection) new URL(url).openConnection();

                // Define que a conexão pode enviar informações e obtê-las de volta:
                this.request.setDoOutput(true);
                this.request.setDoInput(true);

                // Define o content-type:
                this.request.setRequestProperty("Content-Type", "application/json");

                // Define o método da requisição:
                this.request.setRequestMethod("DELETE");

                String authHeaderValue = "Bearer " + new String(token);    // cabeçalho de com autenticação

                this.request.setRequestProperty("Authorization", authHeaderValue);   
                
                // Conecta na URL:
                this.request.connect();

                // Escreve o objeto JSON usando o OutputStream da requisição:
                try (OutputStream outputStream = this.request.getOutputStream()) {
                    outputStream.write(json.getBytes("UTF-8"));
                }

                // Caso você queira usar o código HTTP para fazer alguma coisa, descomente esta linha.
            return new Response(this.request.getResponseCode(),readResponse(this.request));
            } catch (IOException ex) {
                return new Response(404);
            }  finally {
                this.request.disconnect();
            }
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
