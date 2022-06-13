package com.example.my_movies_db.service;

import com.example.my_movies_db.model.entities.Movie;

import java.util.Optional;

public interface MovieService {

    Optional<Movie> getMovie(int movieId);

    void saveMovie(Movie movie);

    void deleteMovie(int movieId);
}
