package com.example.my_movies_db.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler {

    /**
     * Обработать исключение: если в запросе поступил id фильма которого нет в БД - вернуть JSON
     * @param noSuchMovieException - кастомная ошибка из пакета com.example.my_movies_db.exception_handling
     * @return - возвращает Response Entity из MovieIncorrectData для формирования JSON
     */
    @ExceptionHandler
    public ResponseEntity<MovieIncorrectData> handleException(NoSuchMovieException noSuchMovieException){
        MovieIncorrectData movieIncorrectData = new MovieIncorrectData();
        movieIncorrectData.setInfo(noSuchMovieException.getMessage());
        movieIncorrectData.setCode(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(movieIncorrectData, HttpStatus.NOT_FOUND);
    }

    /**
     * Обработать исключение: если в запросе вместо id поступил левый текст - вернуть JSON,
     * созданный из MovieIncorrectData с текстом ошибки
     * @param e - любая ошибка
     * @return - возвращает Response Entity из MovieIncorrectData для формирования JSON
     */
//    @ExceptionHandler
//    public ResponseEntity<MovieIncorrectData> handleException(Exception e){
//        MovieIncorrectData movieIncorrectData = new MovieIncorrectData();
//        movieIncorrectData.setInfo(e.getMessage());
//        movieIncorrectData.setCode(HttpStatus.BAD_REQUEST.toString());
//        return new ResponseEntity<>(movieIncorrectData, HttpStatus.BAD_REQUEST);
//    }
}
