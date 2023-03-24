package com.example.ticket.repositories;

import com.example.ticket.entities.Airplane;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    Airplane getFirstById(int id);
}
