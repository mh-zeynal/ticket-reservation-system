package com.example.ticket.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserWithPermissionsCompositeKey implements Serializable {
    private Permission permission;

    private User user;
}
