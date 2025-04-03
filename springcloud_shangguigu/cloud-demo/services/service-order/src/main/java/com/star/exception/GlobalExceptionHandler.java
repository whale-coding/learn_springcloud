package com.star.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Classname: GlobalExceptionHandler
 * @Date: 2025/4/3 22:16
 * @Author: 聂建强
 * @Description: 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // @ExceptionHandler(Throwable.class)
    // public String error(Throwable e){
    //     return "";
    // }
}
