package strava.acambieri.skatebuddy.model;

public class RestResponse<T> {
    private T payload;
    private boolean ok;
    private String errorCode;


    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public RestResponse(){

    }

    public RestResponse(T payload){
        this.payload = payload;
        this.ok = true;
    }

    public RestResponse(boolean ok,String errorCode){
        this.ok = ok;
        this.errorCode = errorCode;
    }
}
