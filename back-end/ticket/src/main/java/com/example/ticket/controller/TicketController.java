package com.example.ticket.controller;

import java.util.*;

import com.example.ticket.entities.Airplane;
import com.example.ticket.layers.applicationLayer.PaymentManagement;
import com.example.ticket.repositories.AirplaneRepository;
import com.example.ticket.types.jacksonPojos.TicketPojo;
import com.example.ticket.beans.JacksonMapperComponent;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;

@RequestMapping("api/ticket")
@RestController
public class TicketController {

    @Autowired
    private JacksonMapperComponent jack;

    @Autowired
    private PaymentManagement paymentManagement;
    @Autowired
    private AirplaneRepository repository;

    private ArrayList<Airplane> fakeData;

    public TicketController() {

    }

    @PostMapping("/flights")
    public ResponseEntity<String> getFlights() {
        fakeData = new ArrayList<>();
        com.example.ticket.entities.Airplane airplane = repository.getFirstById(278);
        fakeData.add(airplane);
        fakeData.add(airplane);
        fakeData.add(airplane);
        fakeData.add(airplane);
        fakeData.add(airplane);
        fakeData.add(airplane);
        fakeData.add(airplane);
        fakeData.add(airplane);
        fakeData.add(airplane);
        fakeData.add(airplane);
        fakeData.add(airplane);
        String flightsJson = null;
        try {
            flightsJson = jack.convertToJson(fakeData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(flightsJson, HttpStatus.OK);
    }

    @PostMapping("/reserve")
    public ResponseEntity<?> reserveFlight(@RequestBody TicketPojo body){
        System.out.println(body.getSeat().getSeatNumber());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
