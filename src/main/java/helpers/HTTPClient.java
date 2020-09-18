package helpers;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class HTTPClient {

    private final String USER_AGENT = "Mozilla/5.0";
    public HttpURLConnection request;

    public HTTPClient() {

    }

    public HTTPClient(HttpURLConnection request) {
        this.request = request;
    }

    public String test() throws Exception {
        HTTPClient http = new HTTPClient();

        JSONObject json = new JSONObject();
        json.put("username", "br");
        json.put("password", "br");

        String response_str;

        // exemplo de consumo de API
        // response_str = http.sendPost("https://genxapp.herokuapp.com/api/v1/login/?format=json", json.toString());
        // JSONObject response = new JSONObject(response_str);
        // String a = (String) response.get("access");
        response_str = http.sendGet("https://genxapp.herokuapp.com/api/v1/users/?format=json");

        JSONObject response = new JSONObject(response_str);
        String s = (String) response.get("results");

        System.out.println(s);
        //JSONObject array = new JSONObject(s);

        //String results =  (String) response.get("results");
        //System.out.println(results);
        return "";
    }

    public String sendGet(String url) {

        try {
            URL obj = new URL(url);
            this.request = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            this.request.setRequestMethod("GET");

            //add request header
            this.request.setRequestProperty("User-Agent", USER_AGENT);

           int responseCode = this.request.getResponseCode();
           
           
           return readResponse(this.request);

        } catch (Exception e) {
            return "{Nenhuma String}";
        } finally {

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

    
    public void OtherRead(HttpURLConnection request) {
    	 //BufferedReader in = new BufferedReader(
          //       new InputStreamReader(request.getInputStream()));
         //String inputLine;
         //StringBuffer response = new StringBuffer();

         //while ((inputLine = in.readLine()) != null) {
           //  response.append(inputLine);
         //}
         //in.close();
         //return response.toString();
		
	}
    
}
