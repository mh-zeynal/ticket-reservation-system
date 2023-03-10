package com.example.ticket.repositories;

import com.example.ticket.types.userType.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getFirstByUsernameAndPassword(String username, String password);
    User getFirstByUsername(String username);
    void deleteByUsername(String username);
    long countByUsernameAndEmail(String username, String email);
}
