package com.example.ticket.types.userType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.ticket.types.permission.PermTypes;
import javax.persistence.*;
import java.util.Objects;
//@Entity
//@Table(name = "users", schema = "reservation_schema")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "USER_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class User {
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    @JsonIgnore
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private PermTypes role;

    public User(){}

    public User(String username, String password, String email, String name){
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role.getVal();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(PermTypes role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
