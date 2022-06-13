package com.example.my_movies_db.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * Справочник Ролей пользователей: Актер, Режиссер и пр.
 */
@Entity
@Table(name = "cast_roles")
@Data
public class CastRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cast_role")
    private String name;

}
