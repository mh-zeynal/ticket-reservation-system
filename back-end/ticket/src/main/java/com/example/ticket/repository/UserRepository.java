package com.example.ticket.repository;

import com.example.ticket.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getFirstByUsername(String username);

    Long countByUsernameAndEmail(String username, String email);
}
