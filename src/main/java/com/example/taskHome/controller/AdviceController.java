package com.example.taskHome.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.taskHome.model.exeptions.ExceptionBody;
import com.example.taskHome.model.exeptions.ResourceNotFoundException;

import java.time.LocalDateTime;

/**
 * Контроллер обработки исключений.
 */

@RestControllerAdvice
public class AdviceController {
    /**
     * Обработка исключения ResourceNotFoundException.
     * @param e объект исключения.
     * @return ответ оберткой исключения.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody resourceNotFound(ResourceNotFoundException e){
        ExceptionBody exceptionBody = new ExceptionBody();
        exceptionBody.setMessage(e.getMessage());
        exceptionBody.setLocalDateTime(LocalDateTime.now());
        return exceptionBody;
    }

    /**
     * Обработка исключения Exception
     * @param e объект исключения.
     * @return ответ оберткой исключения.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody badCase(Exception e){
        ExceptionBody exceptionBody = new ExceptionBody();
        exceptionBody.setMessage("Error in the server");
        exceptionBody.setLocalDateTime(LocalDateTime.now());
        return exceptionBody;
    }

}
