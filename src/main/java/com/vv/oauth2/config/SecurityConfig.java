package com.vv.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                                               .requestMatchers("/public").permitAll()
                                               .anyRequest().authenticated()
                                      )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt());
        return http.build();
    }
}
