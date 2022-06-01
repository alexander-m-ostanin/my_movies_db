package com.example.my_movies_db.model.dto;

import com.example.my_movies_db.model.entities.Movie;
import com.example.my_movies_db.model.entities.Person;
import lombok.Data;

import java.util.List;

/**
 * Data Transfer Object, чтобы собрать более красивый JSON на выходе из контроллера
 */
@Data
public class MovieDTO {
    private Movie movie;
    private List<Person> actors;
    private List<Person> directors;

}
