package com.banking.app.exception.customexceptions;

import com.banking.app.exception.entity.ErrorMessage;

public class DuplicateUserException extends RuntimeException{
    ErrorMessage errorMessage =new ErrorMessage();
    public DuplicateUserException(String message,ErrorMessage errorMessage){
        super(message);
        this.errorMessage.setDetail(errorMessage.getDetail());
        this.errorMessage.setType(errorMessage.getType());
        this.errorMessage.setHttpStatusCode(errorMessage.getHttpStatusCode());
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
