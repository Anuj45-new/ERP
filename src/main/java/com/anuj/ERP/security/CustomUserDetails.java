package com.anuj.ERP.security;

import com.anuj.ERP.model.Staff;
import com.anuj.ERP.model.Students;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter @Setter
public class CustomUserDetails implements UserDetails {

    private final Long id;
    private final String password;
    private final String role;

    public CustomUserDetails(Students student) {
        this.id = student.getUid();
        this.password = student.getPassword();
        this.role = "STUDENT";
    }

    public CustomUserDetails(Staff staff) {
        this.id = staff.getSid();
        this.password = staff.getPassword();
        this.role = "STAFF";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority("ROLE_" + role)
        );
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return String.valueOf(id);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}