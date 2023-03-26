package com.example.ticket.model.json;

import lombok.Data;

import java.util.Date;

@Data
public class RouteDto {
    private String origin;
    private String destination;
    private Date flightDate;

}
