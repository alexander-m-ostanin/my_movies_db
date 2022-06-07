package com.example.my_movies_db.model.dto;

import com.example.my_movies_db.model.entities.Movie;
import com.example.my_movies_db.model.entities.MovieTeamMember;
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
     * Метод из полученного на входе листа:
     * @param allMovieTeamMembers
     * получает сэт фильмов,
     * а потом для каждого фильма собирает постер
     * @return
     * возвращает лист постеров
     */
    public List<PosterDTO> buildPosterDTOList(List<MovieTeamMember> allMovieTeamMembers){
        Set<Movie> movies = new HashSet<>();
        allMovieTeamMembers.forEach(movieTeamMember -> movies.add(movieTeamMember.getMovie()));

        List<PosterDTO> posterDTOList = new ArrayList<>();
        for (Movie movie : movies){
            List<MovieTeamMember> movieTeamMembers = new ArrayList<>();
            for (MovieTeamMember movieTeamMember : allMovieTeamMembers){
                if (movieTeamMember.getMovie().equals(movie)){
                    movieTeamMembers.add(movieTeamMember);
                }
            }
            posterDTOList.add(buildPosterDTO(movieTeamMembers));
        }
        return posterDTOList;
    }

    /**
     * Метод из полученного листа:
     * @param movieTeamMembers
     * собирает постер
     * @return
     * возврщает один постер
     */
    public PosterDTO buildPosterDTO(List<MovieTeamMember> movieTeamMembers){
        PosterDTO posterDTO = new PosterDTO();
        posterDTO.setMovie(movieTeamMembers.get(0).getMovie());
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
        posterDTO.setMovieTeam(movieTeam);
        return posterDTO;
    }

    /**
     * Метод из полученного листа
     * @param movieTeamMembers
     * @return
     * возвращает сет уникальных ролей
     */
    private Set<String> getCastRoles (List<MovieTeamMember> movieTeamMembers){
        Set<String> castRoles = new HashSet<>();
        movieTeamMembers.forEach(movieTeamMember -> castRoles.add(movieTeamMember.getCastRole().getName()));
        return castRoles;
    }
}
