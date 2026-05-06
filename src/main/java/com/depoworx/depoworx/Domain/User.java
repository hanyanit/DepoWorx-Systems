package com.depoworx.depoworx.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user") 
public class User {
    @Id @GeneratedValue
    private long id;

    private String name;
    private String email;
    private String companyName;
    private String password;
    private String role; 

    public User() {}

public User(String name, String email, String password, String role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
}

public long getId() {
    return id;
}



    public void setName(String name){
        this.name=name;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setRole(String role){
        this.role=role;
    }

    public void setCompanyName(String companyName){
        this.companyName=companyName;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getPassword(){
        return password;
    }

    public String getRole(){
        return role;
    }

    
}
