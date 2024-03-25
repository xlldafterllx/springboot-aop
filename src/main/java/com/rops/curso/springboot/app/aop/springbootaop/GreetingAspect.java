package com.rops.curso.springboot.app.aop.springbootaop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // cmnt_1.0
    @Before("execution(* com.rops.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void loggerBefore(JoinPoint joinPont) {
        String method = joinPont.getSignature().getName();
        String args = Arrays.toString(joinPont.getArgs());

        logger.info("Antes: " + method + " con los argumentos " + args);
    }

    @After("execution(* com.rops.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPont) {
        String method = joinPont.getSignature().getName();
        String args = Arrays.toString(joinPont.getArgs());

        logger.info("Despues: " + method + " con los argumentos " + args);
    }
}

/*
 * _____ cmnt_1.0 _____
 * @Before("execution(String com.rops.curso.springboot.app.aop.springbootaop.services.GreetingService.sayHello(..))")
 * Usando comodin:
 *  En el retorno:
 *      @Before("execution(* com.rops.curso.springboot.app.aop.springbootaop.services.GreetingService.sayHello(..))")
 *  En el método "*":
 *      @Before("execution(String com.rops.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
 *  En la clase/interfaz "*":
 *      @Before("execution(String com.rops.curso.springboot.app.aop.springbootaop.services.*.sayHello(..))")
 *  En todo:
 *      @Before("execution(* com.rops.curso.springboot.app.aop.springbootaop.services.*.*(..))")
 *  En subpackage del principal ".":
 *      @Before("execution(* com.rops.curso.springboot.app.aop.springbootaop..*.*(..))")
 *  Con una expresión regular, que empiece con "com.rops.curso" y continue con "app.aop.springbootaop":
 *      @Before("execution(* com.rops.curso..app.aop.springbootaop..*.*(..))")
 *  Todo de todo, a cualquier package, clase, interfaz, etc.
 *      @Before("execution(* *.*(..))")
 */