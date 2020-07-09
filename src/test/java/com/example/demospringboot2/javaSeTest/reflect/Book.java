package com.example.demospringboot2.javaSeTest.reflect;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Book {

    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Book() {
    }

    public Book(String name) {
        this.name = name;
        this.price = 0;
    }

    public Book(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
