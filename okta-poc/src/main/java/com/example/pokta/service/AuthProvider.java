package com.example.pokta.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthProvider {


    Authentication getAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("Auth: {}", auth);
        return auth;
    }

}
