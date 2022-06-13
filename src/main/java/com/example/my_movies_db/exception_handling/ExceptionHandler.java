package com.example.my_movies_db.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    /**
     * Обработать исключение: если в запросе поступил id не существующий в БД - вернуть JSON,
     * созданный из EntityIncorrectData с текстом сообщения о не существующем id
     * @param entityNotFoundException - сообщение о не существующим в БД id
     * @return - возвращает Response Entity из EntityIncorrectData для формирования JSON
     */
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<EntityIncorrectData> handleException(EntityNotFoundException entityNotFoundException){
        EntityIncorrectData entityIncorrectData = new EntityIncorrectData();
        entityIncorrectData.setInfo(entityNotFoundException.getMessage());
        entityIncorrectData.setCode(HttpStatus.OK.toString());
        return new ResponseEntity<>(entityIncorrectData, HttpStatus.OK);
    }

    /**
     * Обработать исключение: если в запросе вместо id поступил левый текст - вернуть JSON,
     * созданный из EntityIncorrectData с текстом ошибки
     * @param e - любая ошибка
     * @return - возвращает Response Entity из EntityIncorrectData для формирования JSON
     */
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<EntityIncorrectData> handleException(Exception e){
        EntityIncorrectData entityIncorrectData = new EntityIncorrectData();
        entityIncorrectData.setInfo(e.getMessage());
        entityIncorrectData.setCode(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(entityIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
