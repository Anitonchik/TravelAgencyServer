package com.example.TravelAgencyServer.entity.manager;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    MANAGER;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
