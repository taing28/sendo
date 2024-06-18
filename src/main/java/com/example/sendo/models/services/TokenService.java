package com.example.sendo.models.services;

import com.example.sendo.models.entities.RefreshToken;
import com.example.sendo.models.entities.User;
import com.example.sendo.models.repo.RefreshTokenRepo;
import com.example.sendo.models.services.interfaces.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenService implements ITokenService {
    @Autowired
    private RefreshTokenRepo _tokenRepo;
    @Value("${ra.jwt.expiration}")
    private int JWT_EXPIRATION;

    @Override
    public RefreshToken addNew(Long userId, String jwt) {
        RefreshToken token = new RefreshToken();
        token.setToken(jwt);
        token.setUserToken(new User(userId));
        token.setUserId(userId);
        token.setExpiredTime(LocalDateTime.now().plusSeconds(JWT_EXPIRATION / 1000));
        token = _tokenRepo.save(token);
        return token;
    }
}
