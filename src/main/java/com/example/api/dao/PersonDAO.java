package com.example.api.dao;

import com.example.api.model.Person;

import java.util.UUID;

// operations allowed for DB - Data Access Object
public interface PersonDAO {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {

        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

}
