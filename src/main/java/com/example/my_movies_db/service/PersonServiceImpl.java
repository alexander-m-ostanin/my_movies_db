package com.example.my_movies_db.service;

import com.example.my_movies_db.model.entities.Person;
import com.example.my_movies_db.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Optional<Person> getPersonById(int personId) {
        return personRepository.findById(personId);
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(int personId) {
        personRepository.deleteById(personId);
    }
}
