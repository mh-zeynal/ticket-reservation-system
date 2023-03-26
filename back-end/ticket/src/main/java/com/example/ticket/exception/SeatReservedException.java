package com.example.ticket.exception;

public class SeatReservedException extends Exception{
    public SeatReservedException() {
        super("this seat is already reserved");
    }
}
