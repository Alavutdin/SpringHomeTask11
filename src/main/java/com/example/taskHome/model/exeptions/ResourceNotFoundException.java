package com.example.taskHome.model.exeptions;

/**Исключение при отсутствии данных в базе данных.*/


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
