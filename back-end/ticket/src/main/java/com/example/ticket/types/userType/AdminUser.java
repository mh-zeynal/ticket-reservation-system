package com.example.ticket.types.userType;

import com.example.ticket.types.permission.PermTypes;
import javax.persistence.*;

//@Entity
//@DiscriminatorValue(value = "admin")
public class AdminUser extends User{
    public AdminUser(String username, String password, String email, String name) {
        super(username, password, email, name);
        setRole(PermTypes.ADMIN);
    }

    public AdminUser() {

    }
}
