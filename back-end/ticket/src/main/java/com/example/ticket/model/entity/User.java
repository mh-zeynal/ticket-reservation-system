package com.example.ticket.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user", schema = "ticket_reservation_schema")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserWithPermissions> userWithPermissions;

    public User(String username, String password, String email, String role, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.name = name;
    }
}
