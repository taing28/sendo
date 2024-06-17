package com.example.sendo.security;

import com.example.sendo.models.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CustomUserDetail implements UserDetails {
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private Boolean status;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    //Tu thong tin user chuyen sang thong tin CustomUserDetails
    public static CustomUserDetail mapUserToUserDetail(User user){
        //Lay quyen tu doi tuong user
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRoleName().name());
        //Tra ve doi tuong CustomUserDetails
        return new CustomUserDetail(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getStatus(),
                Collections.singletonList(authority)
        );
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
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
        return this.status;
    }
}
