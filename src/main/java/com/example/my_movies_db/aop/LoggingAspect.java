package com.example.my_movies_db.aop;

import com.example.my_movies_db.model.dto.PosterDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    /**
     * Метод оборавичвается вокуг метода getMovieInfo(@PathVariable int movie_id) класса MovieRestController
     * и логирует результаты его работы
     * @param joinPoint нужен для доступа к информации о сигнатуре метода и параметрах его работы
     * @return возвращает результат работы target метода getMovieInfo(@PathVariable int movie_id) класса MovieRestController
     */
    @Around("Pointcuts.pointcutMovieRestControllerGetMovieInfoMethod()")
    public Object aroundGetMovieInfoAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        int movie_id = (int) args[0];
        log.info(methodSignature.getDeclaringTypeName() +
                ": Попытка метода " + methodSignature.getName() +
                " вернуть PosterDTO для movie_id = " + movie_id);

        Object targetMethodResult;
        try {
            targetMethodResult = joinPoint.proceed();
            PosterDTO posterDTO = (PosterDTO) targetMethodResult;
            log.info(methodSignature.getDeclaringTypeName() +
                    ": Метод " + methodSignature.getName() +
                    " для movie_id = " + movie_id +
                    " успешно вернул " + posterDTO);
        } catch (Throwable e) {
            log.error(methodSignature.getDeclaringTypeName() +
                    ": При выполнении метода " + methodSignature.getName() +
                    " для movie_id = " + movie_id +
                    " произошла ошибка " + e);
            throw new RuntimeException(e);
        }
        return targetMethodResult;
    }

    /**
     * Метод оборавичвается вокуг метода getAllMoviesInfo(@PathVariable int movie_id) класса MovieRestController
     * и логирует результаты его работы
     * @param joinPoint нужен для доступа к информации о сигнатуре метода и параметрах его работы
     * @return возвращает результат работы target метода getAllMoviesInfo(@PathVariable int movie_id) класса MovieRestController
     */
    @Around("Pointcuts.pointcutMovieRestControllerGetAllMoviesInfoMethod()")
    public Object aroundGetAllMoviesInfoAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info(methodSignature.getDeclaringTypeName() +
                ": Попытка метода " + methodSignature.getName() +
                " вернуть " + methodSignature.getReturnType().getSimpleName());

        Object targetMethodResult;
        try {
            targetMethodResult = joinPoint.proceed();
            List<PosterDTO> posterDTOList = (List<PosterDTO>) targetMethodResult;
            log.info(methodSignature.getDeclaringTypeName() +
                    ": Метод " + methodSignature.getName() +
                    " успешно вернул " + posterDTOList);
        } catch (Throwable e) {
            log.error(methodSignature.getDeclaringTypeName() +
                    ": При выполнении метода " + methodSignature.getName() +
                    " произошла ошибка " + e);
            throw new RuntimeException(e);
        }
        return targetMethodResult;
    }



//    Ниже то же самое лигирование getMovieInfo, но размазанное на 3 метода. Пока не решил как лучше

//    @Before(value = "Pointcuts.pointcutMovieRestControllerGetMovieMethod()")
//    public void beforeGetMovieAdvice(JoinPoint joinPoint){
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Object[] args = joinPoint.getArgs();
//        int movie_id = (int) args[0];
//        log.info("MovieRestController: Попытка метода " + methodSignature.getName() +
//                " вернуть PosterDTO для movie_id = " + movie_id);
//    }
//
//    @AfterReturning(value = "Pointcuts.pointcutMovieRestControllerGetMovieMethod()")
//    public void afterReturningGetMovieAdvice(JoinPoint joinPoint){
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Object[] args = joinPoint.getArgs();
//        int movie_id = (int) args[0];
//        log.info("MovieRestController: Метод " + methodSignature.getName() +
//                " успешно вернул PosterDTO для movie_id = " + movie_id);
//    }
//
//    @AfterThrowing(value = "Pointcuts.pointcutMovieRestControllerGetMovieMethod()", throwing = "exception")
//    public void afterThrowingGetMovieAdvice(JoinPoint joinPoint, Throwable exception){
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Object[] args = joinPoint.getArgs();
//        int movie_id = (int) args[0];
//        log.error("MovieRestController: При выполнении метода " +
//                methodSignature.getName() +
//                " для movie_id = " + movie_id +
//                " произошла ошибка "
//                + exception);
//    }



}
