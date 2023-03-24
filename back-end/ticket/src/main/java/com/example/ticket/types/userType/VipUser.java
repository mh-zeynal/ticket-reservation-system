package com.example.ticket.types.userType;

import com.example.ticket.types.permission.PermTypes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
//@DiscriminatorValue(value = "vip")
public class VipUser extends User{
    public VipUser(String username, String password, String email, String name) {
        super(username, password, email, name);
        setRole(PermTypes.VIP);
    }

    public VipUser() {

    }
}
