package com.example.ticket.transportation;

import com.example.ticket.types.seatType.*;
import com.example.ticket.types.seatType.FirstClassSeat;
import com.example.ticket.types.seatType.NormalSeat;
import com.example.ticket.types.seatType.Seat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
@Entity
@Table(name = "airplanes", schema = "reservation_schema")
public class Airplane implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "departure_date", columnDefinition = "DATE", nullable = false)
    private LocalDateTime departureDate;

    @Column(name = "arrival_date", columnDefinition = "DATE", nullable = false)
    private LocalDateTime arrivalDate;

    @OneToMany(mappedBy = "airplane", cascade = CascadeType.ALL
            , orphanRemoval = true)
    private List<Seat> seats;

    public Airplane(int id, String type, String origin, String destination, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.id = id;
        this.type = type;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.seats = new LinkedList<>();
    }

    public Airplane(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void addSeat(int price, int seatNumber){
        Seat seat = new NormalSeat(price, seatNumber);
        seat.setAirplane(this);
        seats.add(seat);
    }

    public void addSeat(int price, int seatNumber, boolean dummy){
        Seat seat = new FirstClassSeat(price, seatNumber);
        seat.setAirplane(this);
        seats.add(seat);
    }

    @Override
    public int compareTo(Object o) {
        if (this.getSeatsUnreserved() < ((Airplane)o).getSeatsUnreserved())
            return -1;
        else if (this.getSeatsUnreserved() == ((Airplane)o).getSeatsUnreserved())
            return 0;
        return 1;
    }

    private int getSeatsUnreserved(){
        int counter = 0;
        for (Seat seat : seats) {
            if (!seat.isReserved())
                counter++;
        }
        return counter;
    }
}
