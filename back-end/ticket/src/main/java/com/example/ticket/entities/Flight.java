package com.example.ticket.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@Table(name = "flight", schema = "ticket_reservation_schema")
public class Flight {

    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @Column(name = "departure_date")
    private Timestamp departureDate;

    @Column(name = "arrival_date")
    private Timestamp arrivalDate;

    @OneToOne(mappedBy = "flight", cascade = CascadeType.ALL)
    private FlightSchedule flightSchedule;
}
