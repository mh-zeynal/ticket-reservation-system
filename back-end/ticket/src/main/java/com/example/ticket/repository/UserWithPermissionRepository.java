package com.example.ticket.repository;

import com.example.ticket.model.entity.UserWithPermissions;
import com.example.ticket.model.entity.UserWithPermissionsCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWithPermissionRepository extends JpaRepository<UserWithPermissions, UserWithPermissionsCompositeKey> {
    List<UserWithPermissions> getAllByUserUsername(String username);
}
