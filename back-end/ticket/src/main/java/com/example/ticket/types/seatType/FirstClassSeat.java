package com.example.ticket.types.seatType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.*;

@Entity
@DiscriminatorValue(value = "first_class")
public class FirstClassSeat extends Seat implements FirstClassService {
    public FirstClassSeat(int price, int seatNumber) {
        super(price, seatNumber);
    }

    public FirstClassSeat() { }

    @Override
    public List<String> getSeatService() {
        return Arrays.asList("massager seat", "next to window", "serving food");
    }
}