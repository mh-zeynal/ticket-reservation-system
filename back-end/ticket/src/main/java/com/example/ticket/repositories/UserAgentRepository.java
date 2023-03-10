package com.example.ticket.repositories;

import com.example.ticket.types.UserAgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAgentRepository extends JpaRepository<UserAgentEntity, Long> {

}
