package com.lvt.demo.bean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidValidator implements ConstraintValidator<DateValid, String> {

    String dateFormat;

    @Override
    public void initialize(DateValid constraintAnnotation) {
        dateFormat = constraintAnnotation.format();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (null == value) {
            return true;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            Date date = simpleDateFormat.parse(value);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
