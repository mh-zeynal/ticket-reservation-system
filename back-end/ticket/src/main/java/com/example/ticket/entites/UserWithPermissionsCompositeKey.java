package com.example.ticket.entites;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserWithPermissionsCompositeKey implements Serializable {
    private Permission permission;

    private User user;
}
