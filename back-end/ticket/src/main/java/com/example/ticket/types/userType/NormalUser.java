package com.example.ticket.types.userType;

import com.example.ticket.types.permission.PermTypes;

import javax.persistence.*;

//@Entity
//@DiscriminatorValue(value = "normal")
public class NormalUser extends User{
    public NormalUser(String username, String password, String email, String name) {
        super(username, password, email, name);
        setRole(PermTypes.NORMAL);
    }

    public NormalUser() {

    }
}
