package com.rops.curso.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class GreetingFooAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("GreetingServicePointcuts.greetingFooLoggerAspectPointCut()")
    public void loggerBefore(JoinPoint joinPont) {
        String method = joinPont.getSignature().getName();
        String args = Arrays.toString(joinPont.getArgs());

        logger.info("Antes(Foo): " + method + " invocado con los argumentos " + args);
    }

    @After("GreetingServicePointcuts.greetingFooLoggerAspectPointCut()")
    public void loggerAfter(JoinPoint joinPont) {
        String method = joinPont.getSignature().getName();
        String args = Arrays.toString(joinPont.getArgs());

        logger.info("Despues(Foo): " + method + " invocado con los argumentos " + args);
    }
}
