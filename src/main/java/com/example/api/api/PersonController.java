package com.example.api.api;

import com.example.api.model.Person;
import com.example.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonController {

    private final PersonService personService;

    @Autowired // dependence injection
    public PersonController(PersonService personService){

        this.personService = personService;

    }
    public void addPerson(Person person){

        personService.addPerson(person);
    }
}
