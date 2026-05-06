package com.depoworx.depoworx.service;

import org.springframework.stereotype.Service;

import com.depoworx.depoworx.DTO.LoginRequest;
import com.depoworx.depoworx.DTO.LoginResponse;
import com.depoworx.depoworx.Domain.User;
import com.depoworx.depoworx.repository.UserRepository;
import com.depoworx.depoworx.security.JwtUtil;

@Service
public class UserService {

    
        private final UserRepository userRepository;
        private JwtUtil jwtUtil;
        
       
        
public UserService(UserRepository userRepository, JwtUtil jwtUtil ) {
    this.userRepository = userRepository;
    this.jwtUtil = jwtUtil;
   // this.passwordEncoder = passwordEncoder;
}
    
        public User register(User user)throws Exception{
            if(userRepository.existsByEmail(user.getEmail())){
                throw new Exception("email already exists");
    
            }
            return userRepository.save(user);
        }
    
        public LoginResponse login(LoginRequest request) {
            User user = userRepository.findByEmail(request.getEmail());
        
            if (user == null) {
                throw new RuntimeException("User not found");
            }
        
            if (!user.getPassword().equals(request.getPassword())) {
                throw new RuntimeException("Invalid password");
            }
        
            String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
            return new LoginResponse(token,user.getName(), user.getEmail(), user.getRole());
        }
        
                                                                    
}
