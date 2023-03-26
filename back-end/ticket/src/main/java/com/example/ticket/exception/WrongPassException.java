package com.example.ticket.exception;

public class WrongPassException extends AccountException{
    public WrongPassException(){
        super("the password you've entered is wrong");
    }
}
