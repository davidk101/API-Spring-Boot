package com.example.api.api;

import com.example.api.model.Person;
import com.example.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping
    public List<Person> getAllPeople(){ // served as a GET request

        return personService.getAllPeople();
    }

}
