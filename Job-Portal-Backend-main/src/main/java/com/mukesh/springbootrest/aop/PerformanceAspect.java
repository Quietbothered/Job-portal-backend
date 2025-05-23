package com.balaji.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.balaji.springbootrest.service.JobService.*(..))")
    public Object monitorPerformance(ProceedingJoinPoint jp) throws Throwable {

        long start = System.currentTimeMillis();

        //execute the method
        Object obj = jp.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Time taken by " + jp.getSignature().getName() + " is : " + (end - start) + "ms"  );

        return obj;
    }
}
