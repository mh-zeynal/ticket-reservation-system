package com.example.ticket.controller;

import com.example.ticket.layers.applicationLayer.PaymentManagement;
import com.example.ticket.model.entity.FlightSchedule;
import com.example.ticket.model.json.RouteDto;
import com.example.ticket.service.JwtComponent;
import com.example.ticket.types.jacksonPojos.TicketPojo;
import com.example.ticket.service.JacksonMapperComponent;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

@RequestMapping("api/ticket")
@RestController
public class TicketController {

    @Autowired
    @Qualifier("jwtComp")
    private JwtComponent jwt;

    @Autowired
    private JacksonMapperComponent jack;

    @Autowired
    private PaymentManagement paymentManagement;

    @PostMapping("/flights")
    public ResponseEntity<String> getFlights(@RequestBody RouteDto route) {

        String flightsJson = null;
        try {
            List<FlightSchedule> flightSchedules =
                    paymentManagement.getFlights(route.getOrigin(), route.getDestination());
            flightsJson = jack.convertToJson(flightSchedules);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(flightsJson, HttpStatus.OK);
    }

    @PostMapping("/reserve")
    public ResponseEntity<?> reserveFlight(@RequestBody TicketPojo body, @CookieValue(name = "mytok") String token){
        String username = jwt.getUsername(token);
//TODO: change ticket dto to get flightSchedule and flightSeat data
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
