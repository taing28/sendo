package com.example.sendo.controller;

import com.example.sendo.libs.InputHelper;
import com.example.sendo.models.dto.request.SignUpRequest;
import com.example.sendo.models.dto.request.UserRequest;
import com.example.sendo.models.dto.response.UserPageDTO;
import com.example.sendo.models.entities.ERole;
import com.example.sendo.models.entities.Role;
import com.example.sendo.models.entities.User;
import com.example.sendo.models.services.EmailService;
import com.example.sendo.models.services.RoleService;
import com.example.sendo.models.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService _userService;
    @Autowired
    private RoleService _roleService;
    @Autowired
    private EmailService _emailService;
    @Autowired
    private PasswordEncoder _passwordEncoder;

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        UserPageDTO users = _userService.findAll(page, size);
        if (users.getContent().isEmpty()) {
            return ResponseEntity.badRequest().body("There is no user");
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping()
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest signUpRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(InputHelper.checkBindingResult(bindingResult));
        }

        if (!signUpRequest.getPassword().equals(signUpRequest.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Password not matched");
        }

        User user = SignUpRequest.toEntity(signUpRequest);
        user.setPassword(_passwordEncoder.encode(signUpRequest.getPassword()));
        if (signUpRequest.getRole() == null) {
            Role userRole = _roleService.findRoleByRoleName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role not found"));
            user.setRole(userRole);
            user.setRoleId(userRole.getId());
        } else {
            switch (signUpRequest.getRole()) {
                case "admin":
                    Role adminRole = _roleService.findRoleByRoleName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role not found"));
                    user.setRole(adminRole);
                    user.setRoleId(adminRole.getId());
                    break;
                case "moderator":
                    Role modRole = _roleService.findRoleByRoleName(ERole.ROLE_MODERATOR).orElseThrow(() -> new RuntimeException("Error: Role not found"));
                    user.setRole(modRole);
                    user.setRoleId(modRole.getId());
                    break;
                case "user":
                    Role userRole = _roleService.findRoleByRoleName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role not found"));
                    user.setRole(userRole);
                    user.setRoleId(userRole.getId());
                    break;
            }
        }

        try {
            user = _userService.addNewUser(user);
            _emailService.sendEmailWithHTML(user.getEmail(),"Welcome to Sendo Club", "<h1>Thanks for becoming our member</h1>"+"<h4>We won't let you down. Be happy with shopping^^!</h4>");
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserRequest userRequest, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(InputHelper.checkBindingResult(bindingResult));
        }
        try {
            User user = _userService.updateNewUser(userRequest);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
