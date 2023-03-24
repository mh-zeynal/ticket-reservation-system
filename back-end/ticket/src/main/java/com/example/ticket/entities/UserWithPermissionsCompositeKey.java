package com.example.ticket.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserWithPermissionsCompositeKey implements Serializable {
    private Permission permission;

    private User user;
}
