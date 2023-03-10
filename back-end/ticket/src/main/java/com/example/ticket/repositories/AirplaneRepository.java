package com.example.ticket.repositories;

import com.example.ticket.transportation.Airplane;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    Airplane getFirstById(int id);
}
