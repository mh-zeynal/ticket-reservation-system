package com.example.ticket.types.seatType;

import com.fasterxml.jackson.annotation.*;
import com.example.ticket.transportation.Airplane;

import javax.persistence.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NormalSeat.class, name = "NormalSeat"),
        @JsonSubTypes.Type(value = FirstClassSeat.class, name = "FirstClassSeat")
})
@Entity
@Table(name = "seats", schema = "reservation_schema")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "SEAT_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_id", nullable = false)
    @JsonIgnore
    private Long seat_id;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "seat_number", nullable = false)
    private int seatNumber;

    @Column(name = "is_reserved", nullable = false)
    private boolean isReserved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id")
    @JsonIgnore
    private Airplane airplane;

    public Seat(){}

    public Seat(int price, int seatNumber) {
        this.price = price;
        this.seatNumber = seatNumber;
        this.isReserved = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getPrice() {
        return price;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public Long getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Long seat_id) {
        this.seat_id = seat_id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
}