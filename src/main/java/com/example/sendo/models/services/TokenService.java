package com.example.sendo.models.services;

import com.example.sendo.models.repo.RefreshTokenRepo;
import com.example.sendo.models.services.interfaces.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService implements ITokenService {
@Autowired
    private RefreshTokenRepo _tokenRepo;
}
