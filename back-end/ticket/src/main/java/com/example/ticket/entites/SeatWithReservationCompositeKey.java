package com.example.ticket.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SeatWithReservationCompositeKey implements Serializable {
    private Reservation reservation;

    private FlightSeat flightSeat;
}
