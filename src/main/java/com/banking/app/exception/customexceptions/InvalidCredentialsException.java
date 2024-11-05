package com.banking.app.exception.customexceptions;

public class InvalidCredentialsException extends RuntimeException{
    private final String type;
    private final Integer httpStatus;
    private final String detail;
    private final String instance;

    public InvalidCredentialsException(String type,Integer httpStatus,String detail,String instance,String message){
        super(message);
        this.type=type;
        this.httpStatus=httpStatus;
        this.detail= detail;
        this.instance= instance;
    }

    public String getType() {
        return type;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public String getDetail() {
        return detail;
    }

    public String getInstance() {
        return instance;
    }
}
