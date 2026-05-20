package com.example.TravelAgencyServer.service.security;

import com.example.TravelAgencyServer.api.security.UserJWTRs;
import com.example.TravelAgencyServer.api.security.UserLoginRq;
import com.example.TravelAgencyServer.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private ManagerService managerService;

    public UserJWTRs login (UserLoginRq user) {
        String login = user.login();
        String password = user.password();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login, password)
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid username or password");
        }

        var userEntity = managerService.findByLogin(login);

        UserDetails userDetails = userDetailsService.loadUserByUsername(login);
        String jwt = jwtService.generateToken(userDetails);
        return new UserJWTRs(jwt, userEntity.getId());
    }

}
