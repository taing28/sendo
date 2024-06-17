package com.example.sendo.security;

import com.example.sendo.models.entities.User;
import com.example.sendo.models.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo _userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = _userRepo.findUsersByEmailEquals(email);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return CustomUserDetail.mapUserToUserDetail(user);
    }
}
