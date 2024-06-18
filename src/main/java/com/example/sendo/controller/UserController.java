package com.example.sendo.controller;

import com.example.sendo.models.dto.request.SignInRequest;
import com.example.sendo.models.dto.response.JwtResponse;
import com.example.sendo.models.dto.response.UserPageDTO;
import com.example.sendo.models.jwt.JwtTokenProvider;
import com.example.sendo.models.services.TokenService;
import com.example.sendo.models.services.UserService;
import com.example.sendo.security.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService _userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/users")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        UserPageDTO users = _userService.findAll(page, size);
        if (users.getContent().isEmpty()) {
            return ResponseEntity.badRequest().body("There is no user");
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/login")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("test");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignInRequest signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();

        String jwt = jwtTokenProvider.generateToken(customUserDetail);
        tokenService.addNew(customUserDetail.getId(), jwt);

        return ResponseEntity.ok(new JwtResponse(jwt,
                customUserDetail.getEmail(), customUserDetail.getStatus(), customUserDetail.getAuthorities().toString()));
    }
}
