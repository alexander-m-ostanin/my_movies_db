package com.example.my_movies_db.service;

import com.example.my_movies_db.model.entities.MovieTeamMember;

import java.util.List;

public interface MovieTeamService {
    List<MovieTeamMember> getMovieTeamMembersByMovieId(int movie_id);
}
