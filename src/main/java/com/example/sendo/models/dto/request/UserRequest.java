package com.example.sendo.models.dto.request;

import com.example.sendo.models.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@NoArgsConstructor
public class UserRequest {
    private Long id;
    private String email;
    private String name;
    private String phone;
    private String password;
    private Boolean status;
}
