package com.example.my_movies_db.controller;

import com.example.my_movies_db.exception_handling.EntityNotFoundException;
import com.example.my_movies_db.model.entities.MoviePersonCastRole;
import com.example.my_movies_db.service.MoviePersonCastRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/movies_cross_people")
public class MoviePersonCastRoleController {

    @Autowired
    private MoviePersonCastRoleService moviePersonCastRoleService;

    @GetMapping("/{moviePersonCastRoleId}")
    public MoviePersonCastRole getMoviePersonCastRole(@PathVariable int moviePersonCastRoleId){
        Optional<MoviePersonCastRole> moviePersonCastRole
                = moviePersonCastRoleService.getMoviePersonCastRole(moviePersonCastRoleId);
        if (moviePersonCastRole.isEmpty()){
            throw new EntityNotFoundException("There is no MoviePersonCastRole with ID = "
                    + moviePersonCastRoleId + " in Database");
        }
        return moviePersonCastRole.get();
    }

    @PostMapping("/")
    public MoviePersonCastRole saveMoviePersonCastRole(@RequestBody MoviePersonCastRole moviePersonCastRole){
        moviePersonCastRoleService.saveMoviePersonCastRole(moviePersonCastRole);
        return moviePersonCastRole;
    }

    @DeleteMapping("/{moviePersonCastRoleId}")
    public String deleteMoviePersonCastRole(@PathVariable int moviePersonCastRoleId){
        moviePersonCastRoleService.deleteMoviePersonCastRole(moviePersonCastRoleId);
        return "MoviePersonCastRole with id = " + moviePersonCastRoleId + " was deleted";
    }

}
