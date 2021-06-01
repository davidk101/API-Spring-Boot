package com.example.api.api;

import com.example.api.model.Person;
import com.example.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/v1/person") // creating endpoint

@RestController // methods to expose endpoints for clients
public class PersonController {

    private final PersonService personService;

    @Autowired // dependence injection
    public PersonController(PersonService personService){

        this.personService = personService;

    }

    @PostMapping
    public void addPerson(@RequestBody Person person){ // converting JSON payload to an object
        personService.addPerson(person);
    }
}
