package com.depoworx.depoworx.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.depoworx.depoworx.DTO.LoginRequest;
import com.depoworx.depoworx.DTO.LoginResponse;
import com.depoworx.depoworx.Domain.User;
import com.depoworx.depoworx.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }


    @PostMapping("/register")
    public User register(@RequestBody User user) throws Exception{
        return userService.register(user);
    }
    @PostMapping("/login")
    public LoginResponse login (@RequestBody LoginRequest request) throws Exception {
        System.out.println("Login attempt for: " + request.getEmail());
        return userService.login(request);
    }

    @GetMapping("/pingulated")
    public String ping() {
        return "pong";
    }




}
