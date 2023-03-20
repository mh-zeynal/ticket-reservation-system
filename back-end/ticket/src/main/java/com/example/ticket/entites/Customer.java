package com.example.ticket.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer", schema = "ticker_reservation_schema")
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @JoinColumn(name = "user_id")
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Column(name = "is_vip")
    private boolean isVIP;
}
