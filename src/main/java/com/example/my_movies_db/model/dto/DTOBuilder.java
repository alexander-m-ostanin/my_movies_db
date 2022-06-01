package com.example.my_movies_db.model.dto;

import com.example.my_movies_db.model.entities.MovieTeamMember;
import com.example.my_movies_db.model.entities.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс со статичными методами, которые собирают DTO. Пока DTO в проекте один.
 * Когда (если) появятся другие DTO надо будет решить что с ним дальше делать и как его развивать.
 */
public class DTOBuilder {

    public static MovieDTO buildMoveDTO(List<MovieTeamMember> movieTeamMembers){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovie(movieTeamMembers.get(0).getMovie());
        List<Person> actors = new ArrayList<>();
        List<Person> directors = new ArrayList<>();
        for (MovieTeamMember movieTeamMember : movieTeamMembers){
            if (movieTeamMember.getCastRole().getName().equals("Actor")){
                actors.add(movieTeamMember.getPerson());
            }
            if (movieTeamMember.getCastRole().getName().equals("Director")){
                directors.add(movieTeamMember.getPerson());
            }
            movieDTO.setActors(actors);
            movieDTO.setDirectors(directors);
        }
        return movieDTO;
    }
}
