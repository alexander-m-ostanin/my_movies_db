package com.example.my_movies_db.model.dto;

import com.example.my_movies_db.model.entities.Role;
import com.example.my_movies_db.model.entities.Movie;
import com.example.my_movies_db.model.entities.Person;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Класс билдер, содержит методы, собирающие PosterDTO. Пока DTO в проекте один.
 * Когда (если) появятся другие DTO надо будет решить что с ним дальше делать и как его развивать.
 * Вероятно создам фабрику
 */
@Component
public class PosterDTOBuilder {

    /**
     * Собрать PosterDTO из фильма
     * @param movie поставляет на вход фильм
     * Далее из фильма извлекаются все его roles и people
     * Далее для каждой role вычисляется индивидуальный набор peopleInRole
     * Далее все это кладется в мапу, которая сетится в PosterDTO
     * @return возвращает собранный PosterDTO
     */
    public PosterDTO buildPosterDTO(Movie movie){
        PosterDTO posterDTO = new PosterDTO();
        posterDTO.setMovie(movie);
        Set<Role> roles = movie.getRoles();
        Set<Person> people = movie.getPeople();
        Map<Role, Set<Person>> movieTeam = new HashMap<>();
        roles.forEach(role -> {
            Set<Person> peopleInRole = new HashSet<>();
            people.forEach(person -> {
                if (person.getRoles().contains(role)){
                    peopleInRole.add(person);
                }
            });
            movieTeam.put(role, peopleInRole);
        });
        posterDTO.setMovieTeam(movieTeam);
        return posterDTO;
    }

}
