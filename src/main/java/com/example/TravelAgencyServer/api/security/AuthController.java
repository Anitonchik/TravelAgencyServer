package com.example.TravelAgencyServer.api.security;

import com.example.TravelAgencyServer.api.Constants;
import com.example.TravelAgencyServer.service.security.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(Constants.LOGIN_URL)
    @Operation(
            summary = "Login",
            security = {} // Без требования авторизации
    )
    public UserJWTRs login(@RequestBody UserLoginRq user) {
        return authService.login(user);
    }

}