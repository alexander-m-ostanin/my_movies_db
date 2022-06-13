package com.example.my_movies_db.service;

import com.example.my_movies_db.model.entities.Movie;
import com.example.my_movies_db.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Optional<Movie> getMovie(int movieId){
        return movieRepository.findById(movieId);
    }

    @Override
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(int movieId) {
        movieRepository.deleteById(movieId);
    }
}
