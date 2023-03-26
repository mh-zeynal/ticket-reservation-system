package com.example.ticket.exception;

public class AlreadyRegisteredException extends AccountException{
    public AlreadyRegisteredException(){
        super("there is another user with this username or email");
    }
}
