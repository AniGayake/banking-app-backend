//package com.banking.app.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf(csrf->csrf.disable())
//                .authorizeHttpRequests(auth->
//                        auth.requestMatchers("/api/login").permitAll()
//                                .anyRequest().authenticated())
//                .authenticationManager(authenticationManager());
//        return httpSecurity.build();
//
//    }
//
//    private AuthenticationManager authenticationManager() {
//        return new ProviderManager(authenticationProvider())
//    }
//
//}
