package com.example.ticket.repositories;

import com.example.ticket.types.permission.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    List<Permission> findPermissionEntityByPermissionType(String RolePattern);
    List<Permission> findAllByPermissionTypeOrPermissionType(String role1, String role2);
}
