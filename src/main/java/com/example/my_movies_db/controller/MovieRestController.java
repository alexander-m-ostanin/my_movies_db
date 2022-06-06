package com.example.my_movies_db.controller;

import com.example.my_movies_db.model.dto.DTOBuilder;
import com.example.my_movies_db.model.dto.MovieDTO;
import com.example.my_movies_db.model.entities.MovieTeamMember;
import com.example.my_movies_db.service.MovieTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    @Autowired
    private MovieTeamService movieTeamService;

    @Autowired
    private DTOBuilder dtoBuilder;

    @GetMapping("/{movie_id}")
    public MovieDTO getMovieInfo(@PathVariable int movie_id) {
        List<MovieTeamMember> movieTeamMembers = movieTeamService.getMovieTeamMembersByMovieId(movie_id);
        return dtoBuilder.buildMoveDTO(movieTeamMembers);
    }

}
