package com.example.my_movies_db.model.entities;

import lombok.Data;

import javax.persistence.*;

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

}
