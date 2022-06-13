package com.example.my_movies_db.service;

import com.example.my_movies_db.model.entities.Person;

import java.util.Optional;

public interface PersonService {

    Optional<Person> getPersonById(int personId);

    void savePerson(Person person);

    void deletePerson(int personId);
}
