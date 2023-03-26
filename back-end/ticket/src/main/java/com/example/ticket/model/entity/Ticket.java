package com.example.ticket.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ticket", schema = "ticket_reservation_schema")
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @OneToOne
    @JoinColumn(name = "seat_flight_id")
    private FlightSeat flightSeat;

    @Column(name = "price")
    private int price;
}
