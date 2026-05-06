package com.depoworx.depoworx.DTO;

public class LoginResponse {

    private String token;
    private String name;
    private String email;
    private String role; 


    public LoginResponse(){};
    public LoginResponse(String token,String name, String email, String role) {
        this.name=name;
        this.token = token;
        this.email = email;
        this.role = role;
    }

    public void setToken(String token){
        this.token=token;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setRole(String role){
        this.role=role;
    }

    public String getToken(){
        return token;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getRole(){
        return role;
    }
}
