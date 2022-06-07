package com.example.my_movies_db.controller;

import com.example.my_movies_db.model.dto.PosterDTOBuilder;
import com.example.my_movies_db.model.dto.PosterDTO;
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
    private PosterDTOBuilder posterDtoBuilder;

    @GetMapping("/{movie_id}")
    public PosterDTO getMovieInfo(@PathVariable int movie_id) {
        List<MovieTeamMember> movieTeamMembers = movieTeamService.getMovieTeamMembersByMovieId(movie_id);
        return posterDtoBuilder.buildPosterDTO(movieTeamMembers);
    }

    @GetMapping("/")
    public List<PosterDTO> getAllMoviesInfo(){
        List<MovieTeamMember> allMovieTeamMembers = movieTeamService.getAllMovieTeamMembers();
        return posterDtoBuilder.buildPosterDTOList(allMovieTeamMembers);
    }

}
