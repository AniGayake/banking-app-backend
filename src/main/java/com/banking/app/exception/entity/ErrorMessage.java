package com.banking.app.exception.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessage {
    @JsonProperty("type")
    private String type;
    @JsonProperty("httpStatus")
    private Integer httpStatusCode;
    @JsonProperty("detail")
    private String detail;

    public ErrorMessage(){

    }

    public ErrorMessage(String type, Integer httpStatusCode, String detail) {
        this.type = type;
        this.httpStatusCode = httpStatusCode;
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
//    "type": "/errors/incorrect-user-pass",
//            "title": "Incorrect username or password.",
//            "status": 401,
//            "detail": "Authentication failed due to incorrect username or password.",
//            "instance": "/login/log/abc123"
}
