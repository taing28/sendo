package com.example.sendo.models.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String email;
    private Boolean status;
    private String role;

    public JwtResponse(String token, String email, Boolean status, String role) {
        this.token = token;
        this.email = email;
        this.status = status;
        this.role = role;
    }
}
