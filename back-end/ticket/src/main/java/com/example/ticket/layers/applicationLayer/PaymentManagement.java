package com.example.ticket.layers.applicationLayer;

import com.example.ticket.entities.*;
import com.example.ticket.model.entity.*;
import com.example.ticket.repository.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PaymentManagement {

    private FlightScheduleRepository scheduleRepository;

    private FlightSeatRepository flightSeatRepository;

    private CustomerRepository customerRepository;

    private ReservationRepository reservationRepository;

    private TicketRepository ticketRepository;

    public Ticket reserveFlight(FlightSchedule flightSchedule, FlightSeat flightSeat, String username){
        Reservation reservation = new Reservation();
        Customer customer = customerRepository.getCustomerByUserUsername(username);
        reservation.setFlightSchedule(flightSchedule);
        reservation.setCustomer(customer);
        flightSeat.setReserved(true);
        flightSeatRepository.save(flightSeat);
        reservationRepository.save(reservation);
        Ticket ticket = new Ticket();
        ticket.setReservation(reservation);
        ticket.setFlightSeat(flightSeat);
        ticket.setPrice(flightSeat.getSeat().getPrice());
        ticketRepository.save(ticket);
        return ticket;
    }

    public List<FlightSchedule> getFlights(String origin, String destination){
        List<FlightSchedule> flightSchedules = scheduleRepository.getAllByFlightRouteArrivalAirportCityAndFlightRouteDepartureAirportCity(origin, destination);
        return flightSchedules;
    }
}
