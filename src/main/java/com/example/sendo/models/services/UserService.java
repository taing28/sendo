package com.example.sendo.models.services;

import com.example.sendo.models.dto.request.SignUpRequest;
import com.example.sendo.models.dto.response.UserPageDTO;
import com.example.sendo.models.entities.User;
import com.example.sendo.models.repo.UserRepo;
import com.example.sendo.models.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepo _userRepo;

    @Override
    public UserPageDTO findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = _userRepo.findAll(pageable);
        return UserPageDTO.toDTO(users);
    }

    @Override
    public User addNewUser(User user) {
        return _userRepo.save(user);
    }
}
