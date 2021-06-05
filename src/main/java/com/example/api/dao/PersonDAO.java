package com.example.api.dao;

import com.example.api.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// in memory-DB for this example
// UUID - 128 bits (36 characters)
// workflow : PersonDAO -> FakePersonDataAccessService -> PersonService -> PersonController
// operations allowed for DB - Data Access Object

public interface PersonDAO {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {

        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    // implemented in PersonService
    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);

}
