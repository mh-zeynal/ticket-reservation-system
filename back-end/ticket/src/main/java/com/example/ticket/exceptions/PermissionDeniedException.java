package com.example.ticket.exceptions;

public class PermissionDeniedException extends Exception{
    public PermissionDeniedException() {
        super("you are banned from using this option");
    }
}
