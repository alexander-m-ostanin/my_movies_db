package com.example.my_movies_db.service;

import com.example.my_movies_db.model.entities.MoviePersonRole;

import java.util.Optional;

public interface MoviePersonRoleService {

    Optional<MoviePersonRole> getMoviePersonRole(int moviePersonRoleId);

    void saveMoviePersonRole(MoviePersonRole moviePersonRole);

    void deleteMoviePersonRole(int moviePersonRoleId);
}
