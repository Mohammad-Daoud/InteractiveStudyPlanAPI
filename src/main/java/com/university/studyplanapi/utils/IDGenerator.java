package com.university.studyplanapi.utils;

public class IDGenerator {

    private static volatile IDGenerator instance;
    private long id;

    private IDGenerator() {
        this.id = 1;
    }

    public static IDGenerator getInstance() {
        if (instance == null ) {
            synchronized (IDGenerator.class) {
                if (instance == null)
                    instance = new IDGenerator();
            }
        }
        return instance;
    }

    public long generateNewID(){
        return ++id;
    }

    public long getId() {
        return id;
    }
}