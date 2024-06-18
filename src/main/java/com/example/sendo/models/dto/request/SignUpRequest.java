package com.example.sendo.models.dto.request;

import com.example.sendo.models.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;
    private String phone;
    private String role;

    public static User toEntity(SignUpRequest request){
        User user = new User();
        user.setEmail(request.email);
        user.setName(request.name);
        user.setPhone(request.phone);
        user.setStatus(true);
        return user;
    }
}
