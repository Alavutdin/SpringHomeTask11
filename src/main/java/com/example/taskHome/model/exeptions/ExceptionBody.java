package com.example.taskHome.model.exeptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionBody {

    /** Сообщение об исключении.*/
    private String message;

    /** Время создания.*/
    private LocalDateTime localDateTime;

}
