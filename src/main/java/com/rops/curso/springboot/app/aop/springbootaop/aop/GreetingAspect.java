package com.rops.curso.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // cmnt_1.0
    @Before("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPont) {
        String method = joinPont.getSignature().getName();
        String args = Arrays.toString(joinPont.getArgs());

        logger.info("Antes: " + method + " con los argumentos " + args);
    }

    @After("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPont) {
        String method = joinPont.getSignature().getName();
        String args = Arrays.toString(joinPont.getArgs());

        logger.info("Despues: " + method + " con los argumentos " + args);
    }

    @AfterReturning("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinPont) {
        String method = joinPont.getSignature().getName();
        String args = Arrays.toString(joinPont.getArgs());

        logger.info("Despues(Retorno): " + method + " con los argumentos " + args);
    }

    @AfterThrowing("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPont) {
        String method = joinPont.getSignature().getName();
        String args = Arrays.toString(joinPont.getArgs());

        logger.info("Despues(Excepcion): " + method + " con los argumentos " + args);
    }

    @Around("GreetingServicePointcuts.greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;

        try {            
            logger.info("Antes(Around): El metodo " + method + "() con los parametros " + args); // Algo antes
            result = joinPoint.proceed();            
            logger.info("Despues(Around-Return): El metodo " + method + "() retorna el resultado " + result); // Algo después
            return result;
        } catch (Throwable e) {            
            logger.error("Despues(Around-Exception): Error en la llamada del metodo " + method + "()"); // Algo para manejar el error
            throw e;
        }
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