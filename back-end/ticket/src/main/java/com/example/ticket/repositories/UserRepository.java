package com.example.ticket.repositories;

import com.example.ticket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getFirstByUsername(String username);

    Long countByUsernameAndEmail(String username, String email);
}
