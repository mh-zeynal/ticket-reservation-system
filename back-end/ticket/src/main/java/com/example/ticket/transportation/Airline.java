package com.example.ticket.transportation;

import com.example.ticket.layers.dataLayer.Dao;
import com.example.ticket.layers.dataLayer.FileAirplaneDao;
import com.example.ticket.types.seatType.Seat;

import java.io.Serializable;
import java.util.*;

public abstract class Airline implements Serializable {
    private String airlineName;
    private Dao<Airplane> airplaneDao;
    public Airline(String airlineName, String path){
        this.airlineName = airlineName;
        this.airplaneDao = new FileAirplaneDao(path, airlineName);
    }

    public ArrayList<Airplane> getIntendedFlights(String origin, String destination){
        ArrayList<Airplane> airplaneList = new ArrayList<>();
        for (Airplane airplane : airplaneDao.loadAll()) {
            if (airplane.getOrigin().equals(origin) && airplane.getDestination().equals(destination))
                airplaneList.add(airplane);
        }
        return airplaneList.size() == 0 ? null : airplaneList;
    }

    public Seat updateSeats(int seatNumber, String info, int flightId){
        Seat seat = null;
//        for (Airplane airplane : airplanes.get(info)) {
//            if (airplane.getId() == flightId){
//                seat = airplane.getSeat(seatNumber);
//                break;
//            }
//        }
//        removeAirplane(info);
        return seat;
    }
}
