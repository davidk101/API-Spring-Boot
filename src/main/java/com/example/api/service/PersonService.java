package com.example.api.service;

import com.example.api.model.Person;
import com.example.api.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO){

        this.personDAO = personDAO;
    }

    public int addPerson(Person person){

        return personDAO.insertPerson(person);

    }
}
