package com.example.my_movies_db.model.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "movies_people_roles")
public class MoviePersonRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "person_id")
    private int personId;

    @Column(name = "role_id")
    private int roleId;
}
