package com.balaji.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    @Around("execution(* com.balaji.springbootrest.service.JobService.getJob(..)) && args(postId)")
    public Object validAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {

        //validation
        if(postId < 0){
            LOGGER.info("Negative value found, updating it.");
            postId = - postId;
        }

        Object obj = jp.proceed(new Object[]{postId});

        return obj;
    }
}
