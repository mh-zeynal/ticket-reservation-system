package com.example.ticket.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;

@Data
@Entity
@NoArgsConstructor
@Table(name = "airport", schema = "ticket_reservation_schema")
public class Airport {
    @Id
    @Column(name = "airport_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airportId;

    @Size(max = 3, min = 3)
    @Column(name = "airport_code", nullable = false)
    private String airportCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "timezone", nullable = false)
    private String timeZone;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Flight> flights;

    public TimeZone getTimeZone() {
        return TimeZone.getTimeZone(ZoneId.of(timeZone));
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone.toZoneId().getId();
    }
}
