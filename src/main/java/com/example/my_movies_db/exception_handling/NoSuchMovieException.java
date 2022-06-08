package com.example.my_movies_db.exception_handling;

public class NoSuchMovieException extends RuntimeException {
    public NoSuchMovieException(String message) {
        super(message);
    }
}
