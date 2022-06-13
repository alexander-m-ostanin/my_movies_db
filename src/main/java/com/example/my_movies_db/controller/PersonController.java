package com.example.my_movies_db.controller;

import com.example.my_movies_db.exception_handling.EntityNotFoundException;
import com.example.my_movies_db.model.entities.Person;
import com.example.my_movies_db.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{personId}")
    public Person getPerson (@PathVariable int personId){
        Optional<Person> person = personService.getPersonById(personId);
        if (person.isEmpty()){
            throw new EntityNotFoundException("There is no Person with ID = " + personId + " in Database");
        }
        return person.get();
    }

    @PostMapping("/")
    public Person savePerson (@RequestBody Person person){
        personService.savePerson(person);
        return person;
    }

    @DeleteMapping("/{personId}")
    public String deletePerson(@PathVariable int personId){
        personService.deletePerson(personId);
        return "Person with id = " + personId + " was deleted";
    }
}
