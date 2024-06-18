package com.example.sendo.models.services.interfaces;

import com.example.sendo.models.dto.response.UserPageDTO;

public interface IUserService {
    UserPageDTO findAll(int page, int size);
}
