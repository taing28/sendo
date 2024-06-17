package com.example.sendo.models.services;

import com.example.sendo.models.repo.UserRepo;
import com.example.sendo.models.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepo userRepo;
}
