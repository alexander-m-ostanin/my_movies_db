package com.example.my_movies_db.service;

import com.example.my_movies_db.model.entities.MoviePersonCastRole;
import com.example.my_movies_db.repository.MoviePersonCastRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MoviePersonCastRoleServiceImpl implements MoviePersonCastRoleService{

    @Autowired
    private MoviePersonCastRoleRepository moviePersonCastRoleRepository;

    @Override
    public Optional<MoviePersonCastRole> getMoviePersonCastRole(int moviePersonCastRoleId) {
        return moviePersonCastRoleRepository.findById(moviePersonCastRoleId);
    }

    @Override
    public void saveMoviePersonCastRole(MoviePersonCastRole moviePersonCastRole) {
        moviePersonCastRoleRepository.save(moviePersonCastRole);
    }

    @Override
    public void deleteMoviePersonCastRole(int moviePersonCastRoleId) {
        moviePersonCastRoleRepository.deleteById(moviePersonCastRoleId);
    }
}
