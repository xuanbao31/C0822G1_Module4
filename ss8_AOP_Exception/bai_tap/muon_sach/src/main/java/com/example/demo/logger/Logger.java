package com.example.demo.logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @AfterThrowing(value = "execution(* com.example.demo.controller.BookController.oder(..))")
    public void checkEx() {
        System.out.println("----------------");

        System.out.println("ERROR");
    }

    @After(value = "execution(* com.example.demo.controller.BookController.oder(..))")
    public void checkOk() {
        System.out.println("----------------");
        System.out.println("OK");
    }
}
