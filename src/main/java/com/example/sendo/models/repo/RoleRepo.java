package com.example.sendo.models.repo;

import com.example.sendo.models.entities.ERole;
import com.example.sendo.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findRolesByRoleName(ERole roleName);
}
