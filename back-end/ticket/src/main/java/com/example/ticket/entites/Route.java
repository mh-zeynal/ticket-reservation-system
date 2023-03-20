package com.example.ticket.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "route", schema = "ticket_reservation_schema")
public class Route {
    @Id
    @Column(name = "route_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @Column(name = "distance")
    private float distance;

    @Column(name = "travel_time")
    private float travelTime;

    @OneToOne(mappedBy = "flight", cascade = CascadeType.ALL)
    private Flight flights;
}
