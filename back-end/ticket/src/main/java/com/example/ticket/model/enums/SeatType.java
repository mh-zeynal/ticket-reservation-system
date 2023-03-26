package com.example.ticket.model.enums;

public enum SeatType {
    WINDOW_SEAT("window"),
    AISLE_SEAT("aisle"),
    MIDDLE_SEAT("middle");

    private String seatType;

    SeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getSeatType() {
        return seatType;
    }
}
