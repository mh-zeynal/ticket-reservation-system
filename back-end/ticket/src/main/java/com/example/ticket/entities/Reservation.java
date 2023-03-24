package com.example.ticket.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@Table(name = "reservation", schema = "ticket_reservation_schema")
public class Reservation {

    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "flight_schedule_id")
    private FlightSchedule flightSchedule;

    @Column(name = "status")
    private String status;

    @Column(name = "reservation_time")
    private Timestamp reservationTime;

    @JoinColumn(name = "customer_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
}
