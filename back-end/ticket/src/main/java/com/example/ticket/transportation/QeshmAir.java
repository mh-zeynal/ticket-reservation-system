package com.example.ticket.transportation;

import java.util.*;

public class QeshmAir extends Airline implements SpecialSellOffers{
    public QeshmAir(String airlineName, String path) {
        super(airlineName, path);
    }

    @Override
    public List<Airplane> getOffers(String flightInfo) {
//        LinkedList<Airplane> offers = new LinkedList<>();
//        for (String info : airplanes.keySet()) {
//            if (info.equals(flightInfo)) {
//                Collections.sort(airplanes.get(info));
//                offers.add(airplanes.get(info).get(0));
//            }
//        }
//        return offers;
        return null;
    }
}
