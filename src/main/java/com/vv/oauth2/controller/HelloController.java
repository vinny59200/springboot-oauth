package com.vv.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;

@RestController
public class HelloController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Hello from public!";
    }

    @GetMapping("/private")
    public String privateEndpoint(@AuthenticationPrincipal Jwt jwt) {
        return "Hello " + jwt.getSubject();
    }
}
