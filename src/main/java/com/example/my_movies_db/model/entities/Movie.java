package com.example.my_movies_db.model.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Хранилище фильмов
 */
@Entity
@Table(name = "movies")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

}
