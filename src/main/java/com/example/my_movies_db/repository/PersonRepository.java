package com.example.my_movies_db.repository;

import com.example.my_movies_db.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
