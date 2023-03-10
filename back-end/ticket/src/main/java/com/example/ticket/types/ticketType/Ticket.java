package com.example.ticket.types.ticketType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Table(name = "tickets", schema = "reservation_schema")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    @Column(name = "firstname",  nullable = false)
    private String firstname;

    @Column(name = "lastname",  nullable = false)
    private String lastname;

    @Column(name = "departure_date", columnDefinition = "DATE", nullable = false)
    private LocalDateTime departureDate;

    @Column(name = "arrival_date", columnDefinition = "DATE",  nullable = false)
    private LocalDateTime arrivalDate;

    @Column(name = "seat_number",  nullable = false)
    private int seatNumber;

    private int price;
    private String origin;
    private String destination;
    private String airlineName;
    private Calendar reservationDate;

    public Ticket(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Calendar getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Calendar reservationDate) {
        this.reservationDate = reservationDate;
    }
}
