package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {

    private final UUID id;
    private final String name;

    // constructor
    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id; // generated from server and need not be sent from Postman client
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
