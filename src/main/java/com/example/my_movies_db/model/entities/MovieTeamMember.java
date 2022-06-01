package com.example.my_movies_db.model.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Кросс таблица, связывающая таблицы с Фильмами, Людьми и Ролями
 */
@Data
@Entity
@Table(name = "movies_cross_people")
public class MovieTeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    Movie movie;

    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne
    @JoinColumn(name = "cast_role_id")
    CastRole castRole;

}
