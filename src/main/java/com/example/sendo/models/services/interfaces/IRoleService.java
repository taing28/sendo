package com.example.sendo.models.services.interfaces;

import com.example.sendo.models.entities.ERole;
import com.example.sendo.models.entities.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findRoleByRoleName(ERole roleName);
}
