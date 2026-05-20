package com.example.TravelAgencyServer.service.security;

import com.example.TravelAgencyServer.entity.manager.UserRole;
import com.example.TravelAgencyServer.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        var user = managerRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Set<? extends GrantedAuthority> authorities = Set.of(UserRole.MANAGER);

        return User
                .builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}