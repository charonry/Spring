package com.init.spring.beans.generic;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> baseRepository;

    public void add() {
        System.out.println("BaseService add...");
        System.out.println(baseRepository);
    }
}
