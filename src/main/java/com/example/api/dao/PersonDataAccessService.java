package com.example.api.dao;

import com.example.api.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// dependence injection
// DB implementation
// a container is running and exposing port 5432(5432 is the default port for running a postgres instance using a docker image)
// docker exec -it <containerID> bin/bash -> enter container
// psql -U postgres -> to fire psql queries to postgres
// \c demodb -> connect to demodb Database
@Repository("postgres")

public class PersonDataAccessService implements PersonDAO{
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return Arrays.asList(new Person(UUID.randomUUID(), "IMPORTED FROM POSTGRES DB" ));
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
