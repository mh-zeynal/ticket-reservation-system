package com.example.ticket.layers.dataLayer;

import java.io.*;
import java.util.*;

public abstract class FileDao<T> implements Dao<T>{
    protected String defaultDirectory;
    protected String fileExtension;

    public FileDao(String appPath, String directory){
        this.defaultDirectory = appPath + directory;
        this.fileExtension = ".bin";
    }

    @Override
    public T load(String path) {
        if (!fileExists(path))
            return null;
        T t = null;
        System.out.println(defaultDirectory + formatPath(path));
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(defaultDirectory + formatPath(path)))) {
            t = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public List<T> loadAll() {
        List<T> types = new LinkedList<>();
        File directory = new File(defaultDirectory);
        for (File file : directory.listFiles()) {
            if (!file.isDirectory()){
                types.add(load(file.getName()));
            }
        }
        return types;
    }

    @Override
    public void save(T t) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getPath(t)))) {
            oos.writeObject(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAll(List<T> list) {
        list.forEach(this::save);
    }

    public void delete(T t) {
        File file = new File(getPath(t));
        file.delete();
    }

    public String formatPath(String path){
        if (!path.contains(fileExtension))
            return path + fileExtension;
        return path;
    }

    public boolean fileExists(String path) {
        File file = new File(defaultDirectory + formatPath(path));
        return file.exists();
    }

    public abstract String getPath(T t);
}
