package com.example.my_movies_db.controller;

import com.example.my_movies_db.exception_handling.EntityNotFoundException;
import com.example.my_movies_db.model.entities.MoviePersonRole;
import com.example.my_movies_db.service.MoviePersonRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/movies-people-roles")
public class MoviePersonRoleController {

    @Autowired
    private MoviePersonRoleService moviePersonRoleService;

    @GetMapping("/{moviePersonRoleId}")
    public MoviePersonRole getMoviePersonRole(@PathVariable int moviePersonRoleId){
        Optional<MoviePersonRole> moviePersonRole
                = moviePersonRoleService.getMoviePersonRole(moviePersonRoleId);
        if (moviePersonRole.isEmpty()){
            throw new EntityNotFoundException("There is no MoviePersonRole with ID = "
                    + moviePersonRoleId + " in Database");
        }
        return moviePersonRole.get();
    }

    @PostMapping("/")
    public MoviePersonRole saveMoviePersonRole(@RequestBody MoviePersonRole moviePersonRole){
        moviePersonRoleService.saveMoviePersonRole(moviePersonRole);
        return moviePersonRole;
    }

    @DeleteMapping("/{moviePersonRoleId}")
    public String deleteMoviePersonRole(@PathVariable int moviePersonRoleId){
        moviePersonRoleService.deleteMoviePersonRole(moviePersonRoleId);
        return "MoviePersonRole with id = " + moviePersonRoleId + " was deleted";
    }

}
