package com.example.ticket.repository;

import com.example.ticket.model.entity.FlightSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSeatRepository extends JpaRepository<FlightSeat, Long> { }
