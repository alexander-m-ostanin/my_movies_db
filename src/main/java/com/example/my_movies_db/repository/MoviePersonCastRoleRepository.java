package com.example.my_movies_db.repository;

import com.example.my_movies_db.model.entities.MoviePersonCastRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviePersonCastRoleRepository extends JpaRepository<MoviePersonCastRole, Integer> {
}
