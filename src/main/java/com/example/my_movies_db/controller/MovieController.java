package com.example.my_movies_db.controller;

import com.example.my_movies_db.exception_handling.EntityNotFoundException;
import com.example.my_movies_db.model.dto.PosterDTOBuilder;
import com.example.my_movies_db.model.dto.PosterDTO;
import com.example.my_movies_db.model.entities.Movie;
import com.example.my_movies_db.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private PosterDTOBuilder posterDtoBuilder;

    @Autowired
    private MovieServiceImpl movieService;

    @GetMapping("/poster/{movieId}")
    public PosterDTO getMoviePoster(@PathVariable int movieId){
        Optional<Movie> movie = movieService.getMovie(movieId);
        if (movie.isEmpty()){
            throw new EntityNotFoundException("There is no Movie with ID = " + movieId + " in Database");
        }
        return posterDtoBuilder.buildPosterDTO(movie.get());
    }

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable int movieId){
        Optional<Movie> movie = movieService.getMovie(movieId);
        if (movie.isEmpty()){
            throw new EntityNotFoundException("There is no Movie with ID = " + movieId + " in Database");
        }
        return movie.get();
    }

    @PostMapping("/")
    public Movie saveMovie(@RequestBody Movie movie){
        movieService.saveMovie(movie);
        return movie;
    }

    @DeleteMapping("/{movieId}")
    public String deleteMovie(@PathVariable int movieId){
        movieService.deleteMovie(movieId);
        return "Movie with id = " + movieId + " was deleted";
    }


}
