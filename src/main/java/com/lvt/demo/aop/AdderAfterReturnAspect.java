package com.lvt.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdderAfterReturnAspect {
    private Logger log = LoggerFactory.getLogger(AdderAfterReturnAspect.class);

    public void afterReturn(Object returnValue) throws Throwable{
        log.info("return value was {}", returnValue);
    }
}
