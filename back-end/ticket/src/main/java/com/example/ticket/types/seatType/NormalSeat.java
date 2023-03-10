package com.example.ticket.types.seatType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "normal")
public class NormalSeat extends Seat{
    public NormalSeat(int price, int seatNumber) {
        super(price, seatNumber);
    }

    public NormalSeat() {}
}