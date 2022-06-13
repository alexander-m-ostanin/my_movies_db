package com.example.my_movies_db.service;

import com.example.my_movies_db.model.entities.MoviePersonCastRole;

import java.util.Optional;

public interface MoviePersonCastRoleService {

    Optional<MoviePersonCastRole> getMoviePersonCastRole(int moviePersonCastRoleId);

    void saveMoviePersonCastRole(MoviePersonCastRole moviePersonCastRole);

    void deleteMoviePersonCastRole(int moviePersonCastRoleId);
}
