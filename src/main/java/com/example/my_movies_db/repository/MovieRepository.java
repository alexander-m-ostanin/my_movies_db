package com.example.my_movies_db.repository;

import com.example.my_movies_db.model.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
