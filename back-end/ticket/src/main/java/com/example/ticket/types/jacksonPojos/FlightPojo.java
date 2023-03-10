package com.example.ticket.types.jacksonPojos;

public class FlightPojo {
    private String origin;
    private String destination;
    private String flightDate;

    public String getFlightDate() {
        return flightDate;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
