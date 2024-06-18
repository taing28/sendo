package com.example.sendo.models.services.interfaces;

import com.example.sendo.models.entities.RefreshToken;

public interface ITokenService {
    RefreshToken addNew(Long userId, String jwt);
}
