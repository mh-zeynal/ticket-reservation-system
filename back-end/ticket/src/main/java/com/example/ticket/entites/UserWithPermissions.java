package com.example.ticket.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@IdClass(UserWithPermissionsCompositeKey.class)
@Table(name = "user_has__permissions", schema = "ticket_reservation_schema")
public class UserWithPermissions {
    @OneToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
