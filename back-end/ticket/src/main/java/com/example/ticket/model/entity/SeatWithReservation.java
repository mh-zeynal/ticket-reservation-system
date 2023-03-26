package com.example.ticket.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@IdClass(SeatWithReservationCompositeKey.class)
@Table(name = "seat_reservation", schema = "ticket_reservation_schema")
public class SeatWithReservation {

    @Id
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @Id
    @OneToOne
    @JoinColumn(name = "seat_flight_id")
    private FlightSeat flightSeat;
}
