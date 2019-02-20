package com.lvt.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {

    Logger logger = LoggerFactory.getLogger(EmployeeAspect.class);

    @Before("execution(* com.lvt.demo.model.Employee.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info(" before : name method is {" + joinPoint.getSignature().getName() + "}");
    }

    @After("execution(* com.lvt.demo.model.Employee.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info(" after : name method is {" + joinPoint.getSignature().getName() + "}");
    }

    @Before("execution(* com.lvt.demo.service.*.get*())")
    public void getAllAdvice() {
        logger.info("Service method getter called before");
    }

    @After("execution(* com.lvt.demo.service.*.callAll())")
    public void logAfterServiceCall(JoinPoint joinPoint) {
        logger.info("after : service call all have name : {" + joinPoint.getSignature().getName() + "}");
    }

    @AfterThrowing(pointcut="execution(* com.lvt.demo.service.*.*(..))",
            throwing="e")
    public void logAfterThrowing(JoinPoint joinPoint, IllegalArgumentException e) {
        logger.error(
                "Exception in {}.{}() with cause = \'{}\' and exception = \'{}\', responseBody = {}",
                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
                e.getCause() != null ? e.getCause() : "NULL", e.getMessage(), "ok", e);
    }
}
