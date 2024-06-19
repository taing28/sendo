package com.example.sendo.models.services.interfaces;

import com.example.sendo.models.dto.request.UserRequest;
import com.example.sendo.models.dto.response.UserPageDTO;
import com.example.sendo.models.entities.User;

public interface IUserService {
    UserPageDTO findAll(int page, int size);
    User addNewUser(User user) throws Exception;
    User updateNewUser(UserRequest user) throws Exception;
    User findUserByEmail(String email);

}
