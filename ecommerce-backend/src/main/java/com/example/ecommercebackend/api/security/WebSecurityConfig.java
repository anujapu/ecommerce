package com.example.ecommercebackend.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class WebSecurityConfig {
    @Autowired
    JwtAuthFilter jwtAuthFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.csrf().disable().cors().disable();
        httpSecurity.addFilterBefore(jwtAuthFilter, AuthorizationFilter.class);
        httpSecurity.authorizeHttpRequests()
                .requestMatchers("/products").permitAll()
                .requestMatchers("/auth/register").permitAll()
                .requestMatchers("/auth/login").permitAll()
                .requestMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated();
        return httpSecurity.build();
    }

    private static final String[] AUTH_WHITELIST={
        "/v3/api-docs/**",
        "/swagger-ui/**",
        "/swagger-ui.html"
    };
}
