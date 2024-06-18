package com.example.sendo.controller;

import com.example.sendo.models.dto.request.SignInRequest;
import com.example.sendo.models.dto.response.JwtResponse;
import com.example.sendo.models.jwt.JwtTokenProvider;
import com.example.sendo.models.services.TokenService;
import com.example.sendo.security.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private AuthenticationManager _authenticationManager;
    @Autowired
    private JwtTokenProvider _jwtTokenProvider;
    @Autowired
    private TokenService _tokenService;

    @GetMapping("/login")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("test");
    }

    @GetMapping("/user-logged")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> testUserRole(){
        return ResponseEntity.ok("user logged");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignInRequest signInRequest) {
        Authentication authentication = _authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();

        String jwt = _jwtTokenProvider.generateToken(customUserDetail);
        _tokenService.addNew(customUserDetail.getId(), jwt);

        return ResponseEntity.ok(new JwtResponse(jwt,
                customUserDetail.getEmail(), customUserDetail.getStatus(), customUserDetail.getAuthorities().toString()));
    }

}
