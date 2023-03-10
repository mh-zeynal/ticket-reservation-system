package com.example.ticket.layers.dataLayer;

import java.util.List;
import java.util.Map;

public interface Dao<T> {
    T load(String path);

    List<T> loadAll();

    void save(T t);

    void saveAll(List<T> list);

    void delete(T t);
}
