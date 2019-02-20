package com.lvt.demo.bean;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
    String message() default "Age must greater than {value}";

    Class<?>[] groups() default{} ;

    Class<? extends Payload[]>[] payload() default {};

    long min();

    @Target({ElementType.METHOD, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        Age[] value();
    }
}
