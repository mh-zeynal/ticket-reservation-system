package com.example.ticket.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@IdClass(UserWithPermissionsCompositeKey.class)
@Table(name = "user_has_permissions", schema = "ticket_reservation_schema")
public class UserWithPermissions {
    @Id
    @OneToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
