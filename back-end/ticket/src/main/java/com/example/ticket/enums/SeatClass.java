package com.example.ticket.enums;

public enum SeatClass {
    BUSINESS_CLASS("business"),
    ECONOMY_CLASS("economy"),
    FIRST_CLASS("first");

    private String seatClass;

    SeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public String getSeatClass() {
        return this.seatClass;
    }
}
