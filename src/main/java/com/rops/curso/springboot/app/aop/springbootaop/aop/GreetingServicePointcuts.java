package com.rops.curso.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {
    @Pointcut("execution(* com.rops.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void greetingLoggerPointCut() {}

    @Pointcut("execution(* com.rops.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void greetingFooLoggerAspectPointCut() {}
}

/*
 * ____ cmnt_1.0 _____
 * Los métodos deben ser públicos para poder acceder a éstos desde otras clases (GreetingAspect y GreetingFooAspect),
 * ya que ahora que están desacoplados.
 */