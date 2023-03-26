package com.example.ticket.repository;

import com.example.ticket.model.entity.Airplane;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    Airplane getFirstById(int id);
}
