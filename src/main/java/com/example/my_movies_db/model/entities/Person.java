package com.example.my_movies_db.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Таблица с людьми
 */
@Entity
@Table(name = "people")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "movies_cross_people",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "cast_role_id")
    )
    private Set<CastRole> castRoles = new HashSet<>();

    public void addCastRole(CastRole castRole){
        castRoles.add(castRole);
    }

    public void removeCastRole(CastRole castRole){
        castRoles.remove(castRole);
    }

}
