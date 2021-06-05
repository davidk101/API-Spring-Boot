package com.example.api.api;

import com.example.api.model.Person;
import com.example.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

// exposing functions to a REST API

@RequestMapping("api/v1/person") // creating endpoint

@RestController // methods to expose endpoints for clients
public class PersonController {

    private final PersonService personService;

    @Autowired // dependency injection
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

    @GetMapping(path = "{id}") // allows for /id path
    public Person getPersonById(@PathVariable("id") UUID id){ // converting id from postman client to UUID

        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){

        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){

        personService.updatePerson(id, personToUpdate);
    }

}
