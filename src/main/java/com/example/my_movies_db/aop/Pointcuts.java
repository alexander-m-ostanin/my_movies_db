package com.example.my_movies_db.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* com.example.my_movies_db.controller.MovieRestController.get*(..))")
    public void pointcutMovieRestControllerGetMovieMethod(){}

}
