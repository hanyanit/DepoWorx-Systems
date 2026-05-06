package com.depoworx.depoworx.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for API
            .headers(headers -> headers.frameOptions(frame -> frame.disable())) // allow H2 console
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/register").permitAll()
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/createJobCard").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults()); 

        return http.build();
    }
}

