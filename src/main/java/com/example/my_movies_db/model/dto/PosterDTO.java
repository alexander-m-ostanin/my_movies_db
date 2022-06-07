package com.example.my_movies_db.model.dto;

import com.example.my_movies_db.model.entities.Movie;
import com.example.my_movies_db.model.entities.Person;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Data Transfer Object, чтобы собрать более красивый JSON на выходе из контроллера
 */
@Data
public class PosterDTO {
    private Movie movie;
    private Map<String, List<Person>> movieTeam;
}
