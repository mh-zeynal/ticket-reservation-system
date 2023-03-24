package com.example.ticket.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "airplane", schema = "ticket_reservation_schema")
public class Airplane {
    @Id
    @Column(name = "airplane_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplaneId;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    @Column(name = "max_range")
    private int maxRange;

    @Column(name = "max_speed")
    private int maxSpeed;

    @Column(name = "capacity")
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @OneToMany(mappedBy = "airplane", fetch = FetchType.LAZY)
    private List<Flight> flights;

    @OneToMany(mappedBy = "airplane", cascade = CascadeType.ALL)
    private List<Seat> seats;
}
