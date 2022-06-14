package com.example.my_movies_db.model.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Справочник Ролей пользователей: Актер, Режиссер и пр.
 */
@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

}
