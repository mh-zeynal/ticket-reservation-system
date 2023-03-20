package com.example.ticket.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SeatWithServicesCompositeKey implements Serializable {
    private Seat seat;

    private SeatServices seatServices;
}
