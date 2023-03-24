package com.example.ticket.types;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

//@Entity
//@Table(name = "user_agents", schema = "reservation_schema")
public class UserAgentEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "UUID",
            strategy = "it.frogo.journal.dao.model.UUIDGenerator")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "device", nullable = false)
    private String device;

    @Column(name = "os", nullable = false)
    private String os;

    @Column(name = "agent", nullable = false)
    private String agent;

    public UserAgentEntity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
