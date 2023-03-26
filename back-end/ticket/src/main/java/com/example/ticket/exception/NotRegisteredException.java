package com.example.ticket.exception;

public class NotRegisteredException extends AccountException{
    public NotRegisteredException() {
        super("there is no user matching with this username");
    }
}
