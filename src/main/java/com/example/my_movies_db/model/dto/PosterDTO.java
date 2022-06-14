package com.example.my_movies_db.model.dto;

import com.example.my_movies_db.model.entities.Role;
import com.example.my_movies_db.model.entities.Movie;
import com.example.my_movies_db.model.entities.Person;
import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * Data Transfer Object, чтобы собрать более красивый JSON на выходе из контроллера
 */
@Data
public class PosterDTO {
    private Movie movie;
    private Map<Role, Set<Person>> movieTeam;
}
