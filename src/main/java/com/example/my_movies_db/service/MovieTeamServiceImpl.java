package com.example.my_movies_db.service;

import com.example.my_movies_db.model.entities.MovieTeamMember;
import com.example.my_movies_db.repository.MovieTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTeamServiceImpl implements MovieTeamService{
    @Autowired
    MovieTeamRepository movieTeamRepository;

    @Override
    public List<MovieTeamMember> getMovieTeamMembersByMovieId(int movie_id) {
        return movieTeamRepository.findByMovieId(movie_id);
    }

    @Override
    public List<MovieTeamMember> getAllMovieTeamMembers() {
        return movieTeamRepository.findAll();
    }
}
