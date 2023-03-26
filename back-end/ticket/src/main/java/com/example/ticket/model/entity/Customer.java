package com.example.ticket.model.entity;

import com.example.ticket.model.listener.CustomerListener;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@EntityListeners(CustomerListener.class)
@Table(name = "customer", schema = "ticket_reservation_schema")
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
