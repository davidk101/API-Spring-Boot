package com.example.api.model;

import java.util.UUID;

public class Person {

    private final UUID id;
    private final String name;

    // constructor
    public Person(UUID id, String name) {
        this.id = id;
        this.name = name;

    }

    // accessors
    public UUID getId(){

        return id;
    }

    public String getName(){

        return name;
    }


}
