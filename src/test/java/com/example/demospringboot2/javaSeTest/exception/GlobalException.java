package com.example.demospringboot2.javaSeTest.exception;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/25$ 9:37$
 */
public class GlobalException extends Exception {

    public GlobalException(){
        super();
    }

    public GlobalException(String message){
        super(message);
    }

    public GlobalException(String message, Throwable cause){
        super(message, cause);
    }
}
