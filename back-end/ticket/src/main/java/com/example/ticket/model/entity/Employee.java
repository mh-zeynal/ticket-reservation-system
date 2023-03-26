package com.example.ticket.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "customer", schema = "ticket_reservation_schema")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @JoinColumn(name = "user_id")
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Column(name = "department")
    private String department;
}
