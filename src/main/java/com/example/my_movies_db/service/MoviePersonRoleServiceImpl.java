package com.example.my_movies_db.service;

import com.example.my_movies_db.model.entities.MoviePersonRole;
import com.example.my_movies_db.repository.MoviePersonRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MoviePersonRoleServiceImpl implements MoviePersonRoleService {

    @Autowired
    private MoviePersonRoleRepository moviePersonRoleRepository;

    @Override
    public Optional<MoviePersonRole> getMoviePersonRole(int moviePersonRoleId) {
        return moviePersonRoleRepository.findById(moviePersonRoleId);
    }

    @Override
    public void saveMoviePersonRole(MoviePersonRole moviePersonRole) {
        moviePersonRoleRepository.save(moviePersonRole);
    }

    @Override
    public void deleteMoviePersonRole(int moviePersonRoleId) {
        moviePersonRoleRepository.deleteById(moviePersonRoleId);
    }
}
