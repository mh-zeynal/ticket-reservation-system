package com.example.ticket.exceptions;

public class SeatReservedException extends Exception{
    public SeatReservedException() {
        super("this seat is already reserved");
    }
}
