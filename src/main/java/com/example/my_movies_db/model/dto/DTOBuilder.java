package com.example.my_movies_db.model.dto;

import com.example.my_movies_db.model.entities.MovieTeamMember;
import com.example.my_movies_db.model.entities.Person;
import org.aspectj.lang.annotation.Pointcut;

import java.util.*;

/**
 * Класс со статичными методами, которые собирают DTO. Пока DTO в проекте один.
 * Когда (если) появятся другие DTO надо будет решить что с ним дальше делать и как его развивать.
 */
public class DTOBuilder {

    public MovieDTO buildMoveDTO(List<MovieTeamMember> movieTeamMembers){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovie(movieTeamMembers.get(0).getMovie());
        Map<String, List<Person>> movieTeam = new HashMap<>();
        Set<String> castRoles = getCastRoles(movieTeamMembers);
        for (String castRole : castRoles){
            List<Person> roleTeam = new ArrayList<>();
            for (MovieTeamMember movieTeamMember : movieTeamMembers) {
                if (movieTeamMember.getCastRole().getName().equals(castRole)) {
                    roleTeam.add(movieTeamMember.getPerson());
                }
            }
            movieTeam.put(castRole, roleTeam);
        }
        movieDTO.setMovieTeam(movieTeam);
        return movieDTO;
    }

    private Set<String> getCastRoles (List<MovieTeamMember> movieTeamMembers){
        Set<String> castRoles = new HashSet<>();
        for (MovieTeamMember movieTeamMember : movieTeamMembers){
            castRoles.add(movieTeamMember.getCastRole().getName());
        }
        return castRoles;
    }
}
