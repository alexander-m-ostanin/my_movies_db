package com.example.my_movies_db.repository;

import com.example.my_movies_db.model.entities.MovieTeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieTeamRepository extends JpaRepository<MovieTeamMember, Integer> {
    List<MovieTeamMember> findByMovieId(@Param("id") int movieId);
}
