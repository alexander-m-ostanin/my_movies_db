package com.example.my_movies_db.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "movies_cross_people",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "cast_role_id")
    )
    private Set<CastRole> castRoles = new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "movies_cross_people",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Person> people = new HashSet<>();

    public void addCastRole(CastRole castRole){
        castRoles.add(castRole);
    }

    public void removeCastRole(CastRole castRole){
        castRoles.remove(castRole);
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public void removePerson(Person person){
        people.remove(person);
    }


}
