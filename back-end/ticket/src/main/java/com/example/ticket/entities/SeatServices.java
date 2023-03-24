package com.example.ticket.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "seat_services", schema = "ticket_reservation_schema")
public class SeatServices {
    @Id
    @Column(name = "service_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column(name = "service_title")
    private String serviceTitle;

    @Column(name = "service_description")
    private String serviceDescription;

    @OneToMany(mappedBy = "seat_services", cascade = CascadeType.ALL)
    private List<SeatWithServices> seatWithServices;
}
