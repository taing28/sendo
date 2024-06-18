package com.example.sendo.models.services;

import com.example.sendo.models.entities.ERole;
import com.example.sendo.models.entities.Role;
import com.example.sendo.models.repo.RoleRepo;
import com.example.sendo.models.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepo _roleRepo;

    @Override
    public Optional<Role> findRoleByRoleName(ERole roleName) {
        return _roleRepo.findRolesByRoleName(roleName);
    }
}
