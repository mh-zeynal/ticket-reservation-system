package com.example.ticket.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@IdClass(SeatWithServicesCompositeKey.class)
@Table(name = "seat_has+services", schema = "ticket_reservation_schema")
public class SeatWithServices {
    @Id
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Id
    @ManyToOne
    @JoinColumn(name = "service_id")
    private SeatServices seatServices;

}
