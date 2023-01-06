package com.example.formbasicsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Throwable{
        http.httpBasic(
                c -> {
                    c.authenticationEntryPoint(new CustomEntryPoint());
                }
        );
        http.authorizeHttpRequests()
                .anyRequest()
                .authenticated();
        return http.build();
    }
}
