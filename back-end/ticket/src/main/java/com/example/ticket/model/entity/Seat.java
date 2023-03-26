package com.example.ticket.model.entity;

import com.example.ticket.model.enums.SeatClass;
import com.example.ticket.model.enums.SeatType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "seat", schema = "ticket_reservation_schema")
public class Seat {
    @Id
    @Column(name = "seat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @Column(name = "row_number")
    private int rowNumber;

    @Size(min = 1, max = 1)
    @Column(name = "seat_letter")
    private String seatLetter;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_class")
    private SeatClass seatClass;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type")
    private SeatType seatType;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "airplane_id", nullable = false)
    private Airplane airplane;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    private List<FlightSeat> flightSeats;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    private List<SeatWithServices> seatWithServices;
}
