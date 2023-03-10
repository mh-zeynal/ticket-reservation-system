package com.example.ticket.layers.dataLayer;

import com.example.ticket.transportation.Airplane;

public class FileAirplaneDao extends FileDao<Airplane> {
    public FileAirplaneDao(String appPath, String airline) {
        super(appPath, "datas/airlines/" + airline + "/");
    }

    @Override
    public String getPath(Airplane airplane) {
        return null;
    }
}
