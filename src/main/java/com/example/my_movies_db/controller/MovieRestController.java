package com.example.my_movies_db.controller;

import com.example.my_movies_db.exception_handling.NoSuchMovieException;
import com.example.my_movies_db.model.dto.PosterDTOBuilder;
import com.example.my_movies_db.model.dto.PosterDTO;
import com.example.my_movies_db.model.entities.MovieTeamMember;
import com.example.my_movies_db.service.MovieTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    @Autowired
    private MovieTeamService movieTeamService;

    @Autowired
    private PosterDTOBuilder posterDtoBuilder;

    /**
     * Получить информацию о фильме по id фильма
     * @param movie_id - id фильма
     * @return - возвращает постер фильма с его названием и списком участников
     */
    @GetMapping("/{movie_id}")
    public PosterDTO getMovieInfo(@PathVariable int movie_id) {
        List<MovieTeamMember> movieTeamMembers = movieTeamService.getMovieTeamMembersByMovieId(movie_id);
        if (movieTeamMembers == null || movieTeamMembers.isEmpty()){
            throw new NoSuchMovieException("There is no movie with ID = " + movie_id + " in Database");
        }
        return posterDtoBuilder.buildPosterDTO(movieTeamMembers);
    }


    /**
     * Получить информацию обо всех фильмах, содержащихся в БД
     * @return - возвращает список постеров всех фильмов
     */
    @GetMapping("/")
    public List<PosterDTO> getAllMoviesInfo(){
        List<MovieTeamMember> allMovieTeamMembers = movieTeamService.getAllMovieTeamMembers();
        return posterDtoBuilder.buildPosterDTOList(allMovieTeamMembers);
    }

}
