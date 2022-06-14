package com.example.my_movies_db.repository;

import com.example.my_movies_db.model.entities.MoviePersonRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviePersonRoleRepository extends JpaRepository<MoviePersonRole, Integer> {
}
