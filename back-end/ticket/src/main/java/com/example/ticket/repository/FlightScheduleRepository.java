package com.example.ticket.repository;

import com.example.ticket.model.entity.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Long> {
    List<FlightSchedule> getAllByFlightRouteArrivalAirportCityAndFlightRouteDepartureAirportCity(String origin, String destination);
}
