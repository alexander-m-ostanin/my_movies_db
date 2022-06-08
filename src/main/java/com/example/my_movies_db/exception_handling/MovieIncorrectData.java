package com.example.my_movies_db.exception_handling;

import lombok.Data;

/**
 * Entyty для вывода информации об ошибке в JSON
 */
@Data
public class MovieIncorrectData {
    private String info;
    private String code;
}
