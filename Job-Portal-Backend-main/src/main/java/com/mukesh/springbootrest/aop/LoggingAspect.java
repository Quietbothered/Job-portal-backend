package com.balaji.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.balaji.springbootrest.service.JobService.getAllJobs(..))")
    public void logMethod(JoinPoint jp){
        LOGGER.info("Method called " + jp.getSignature().getName());
    }
}
