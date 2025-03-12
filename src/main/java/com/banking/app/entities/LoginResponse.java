package com.banking.app.entities;

public class LoginResponse {
    private String token;
    private long expiresIn;
    public static int a=0;

    public LoginResponse(Builder builder){
        this.token = builder.token;
        this.expiresIn = builder.expiresIn;
    }
    public String getToken() {
        return token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

 public static class Builder{
     private String token;
     private long expiresIn;

     public Builder setToken(String token){
         this.token= token;
         return this;
     }
     public Builder setExpiresIn(long expiresIn){
         this.expiresIn = expiresIn;
         return this;
     }
     public LoginResponse build(){
         return new LoginResponse(this);
     }
 }

}
