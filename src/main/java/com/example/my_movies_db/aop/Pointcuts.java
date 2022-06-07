package com.example.my_movies_db.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* com.example.my_movies_db.controller.MovieRestController.getMovieInfo(..))")
    public void pointcutMovieRestControllerGetMovieInfoMethod(){}

    @Pointcut("execution(* com.example.my_movies_db.controller.MovieRestController.getAllMoviesInfo(..))")
    public void pointcutMovieRestControllerGetAllMoviesInfoMethod(){}

//    Поинткат на случай если позднее захочется проразвлекаться с логгированием PosterDTOBuilder
//    @Pointcut("execution(* com.example.my_movies_db.model.dto.PosterDTOBuilder.buildPosterDTO(..))")
//    public void pointcutDTOBuilderBuildMoveDTOMethod(){}

}
