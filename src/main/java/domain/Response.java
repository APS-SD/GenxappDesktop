package domain;

public class Response {
    private int status_code;
    private String content;

    public Response() {
     
    }
    
    public Response(Integer statusCode) {
        this.status_code = statusCode;
    }
    
    public Response(Integer statusCode, String content) {
        this.status_code = statusCode;
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }
    
}
