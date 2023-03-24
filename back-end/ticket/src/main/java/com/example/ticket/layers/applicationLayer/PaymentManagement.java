package com.example.ticket.layers.applicationLayer;

import com.example.ticket.entities.FlightSchedule;
import com.example.ticket.repositories.FlightScheduleRepository;
import com.example.ticket.transportation.*;
import com.example.ticket.types.ticketType.Ticket;

import java.util.*;

public class PaymentManagement {
    private Map<String, Airline> airlines;
    private List<Ticket> reservedTickets;

    private FlightScheduleRepository scheduleRepository;

    public PaymentManagement(String appPath){
        reservedTickets = new LinkedList<>();
        airlines = new HashMap<>();
        airlines.put("Qeshm Air", new QeshmAir("Qeshm Air", appPath));
        airlines.put("Mahan Air", new MahanAir("Mahan Air", appPath));
    }

    public PaymentManagement(Map<String, Airline> inputAirlines){
        reservedTickets = new LinkedList<>();
        airlines = new HashMap<>(inputAirlines);
    }

    /*public Ticket reserveFlight(String lineName, String src, String dest, Airplane airplane, int seatNumber, User user){
        Seat seat = airlines.get(lineName).updateSeats(seatNumber, src + "-" + dest, airplane.getId());
        Ticket ticket =  new Ticket(user.getName(), airplane.getDepartureDate(),
                airplane.getArrivalDate(), seat.getSeatNumber(),
                seat.getPrice(), src, dest, lineName);
        reservedTickets.add(ticket);
        return ticket;
    }*/

    public List<Ticket> getReservedTickets(){
        return reservedTickets;
    }

    public Map<String, List<Airplane>> getSpecialOffers(String info){
        Map<String, List<Airplane>> offers = new HashMap<>();
        for (String airline : airlines.keySet()) {
            if (airlines.get(airline) instanceof SpecialSellOffers){
                offers.put(airline, ((SpecialSellOffers) airlines.get(airline)).getOffers(info));
            }
        }
        return offers;
    }

    public List<FlightSchedule> getFlights(String origin, String destination){
        List<FlightSchedule> flightSchedules = scheduleRepository.getAllByFlightRouteArrivalAirportCityAndFlightRouteDepartureAirportCity(origin, destination);
        return flightSchedules;
    }
}
