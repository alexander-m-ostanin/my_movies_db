package com.example.my_movies_db.model.dto;

import com.example.my_movies_db.model.entities.CastRole;
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
     * Далее из фильма извлекаются все его castRoles и people
     * Далее для каждой castRole вычисляется индивидуальный набор peoplePerCastRole
     * Далее все это кладется в мапу, которая сетится в PosterDTO
     * @return возвращает собранный PosterDTO
     */
    public PosterDTO buildPosterDTO(Movie movie){
        PosterDTO posterDTO = new PosterDTO();
        posterDTO.setMovie(movie);
        Set<CastRole> castRoles = movie.getCastRoles();
        Set<Person> people = movie.getPeople();
        Map<CastRole, Set<Person>> movieTeam = new HashMap<>();
        castRoles.forEach(castRole -> {
            Set<Person> peoplePerCastRole = new HashSet<>();
            people.forEach(person -> {
                if (person.getCastRoles().contains(castRole)){
                    peoplePerCastRole.add(person);
                }
            });
            movieTeam.put(castRole, peoplePerCastRole);
        });
        posterDTO.setMovieTeam(movieTeam);
        return posterDTO;
    }

}
