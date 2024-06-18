package com.example.sendo.models.services.interfaces;

import com.example.sendo.models.dto.request.SignUpRequest;
import com.example.sendo.models.dto.response.UserPageDTO;
import com.example.sendo.models.entities.User;

public interface IUserService {
    UserPageDTO findAll(int page, int size);
    User addNewUser(User user);
}
