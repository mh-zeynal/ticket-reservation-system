package com.example.ticket.repositories;

import com.example.ticket.entities.UserWithPermissions;
import com.example.ticket.entities.UserWithPermissionsCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWithPermissionRepository extends JpaRepository<UserWithPermissions, UserWithPermissionsCompositeKey> {
    List<UserWithPermissions> getAllByUserUsername(String username);
}
