package com.example.ticket.exceptions;

public class AlreadyRegisteredException extends AccountException{
    public AlreadyRegisteredException(){
        super("there is another user with this username or email");
    }
}
