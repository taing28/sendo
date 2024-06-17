package com.example.sendo.models.services;

import com.example.sendo.models.repo.RoleRepo;
import com.example.sendo.models.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepo _roleRepo;
}
