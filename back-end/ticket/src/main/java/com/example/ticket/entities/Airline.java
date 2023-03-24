package com.example.ticket.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "airline", schema = "ticket_reservation_schema")
public class Airline {
    @Id
    @Column(name = "airplane_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplaneId;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "established")
    private Timestamp established;

    @OneToMany(mappedBy = "airplane", cascade = CascadeType.ALL)
    private List<Airplane> airplanes;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Flight> flights;
}
