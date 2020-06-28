package com.example.demospringboot2.javaSeTest.exception;

/**
 * @Title: TODO
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2020/6/25$ 9:39$
 */
public class BusinessService {

    /**
     * 继承RuntimeException的异常类，为免检异常，不需要捕获或声明
     * @param bought
     */
    public void buy(boolean bought){

        if(bought){
            throw new BusinessException();
        }
        throw new BusinessException();
    }


    /**
     * 继承Exception的异常类，为必检异常，必须声明抛出 或 自捕获处理
     * @param sold
     */
    public void sell(boolean sold) throws GlobalException{

        if(sold){
            throw new GlobalException();
        }
        throw new GlobalException();
    }
}
