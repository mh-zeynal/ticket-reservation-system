package com.example.ticket.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "flightSchedule", schema = "ticket_reservation_schema")
public class FlightSchedule {
    @Id
    @Column(name = "flight_schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightScheduleId;

    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Column(name = "actual_departure_time")
    private Timestamp actualDepartureTime;

    @Column(name = "actual_arrival_time")
    private Timestamp actualArrivalTime;

    @OneToMany(mappedBy = "flightSchedule", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "flightSchedule", cascade = CascadeType.ALL)
    private List<FlightSeat> flightSeats;
}
