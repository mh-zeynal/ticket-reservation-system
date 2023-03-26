package com.example.ticket.exception;

public class AlreadyUpdatedException extends Exception{
    public AlreadyUpdatedException() {
        super("your account has been already updated to VIP");
    }
}
