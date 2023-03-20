package com.example.ticket.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "permission", schema = "ticker_reservation_schema")
public class Permission {

    @Id
    @Column(name = "permission_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
}
