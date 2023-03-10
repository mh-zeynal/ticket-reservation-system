package com.example.ticket.types.optionType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.ticket.types.permission.Permission;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "options", schema = "reservation_schema")
public class Option implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    @JsonIgnore
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToOne
    @JsonIgnore
    Permission permission;

    public Option(){}

    public Option(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Option{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
