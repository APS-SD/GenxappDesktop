package domain;

public class Response<T> {
    private int status_code;
    public T objectModel;

    public Response() {
  
    }

    
    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public T getObjectModel() {
        return objectModel;
    }

    public void setObjectModel(T objectModel) {
        this.objectModel = objectModel;
    }
    
    
    
}
