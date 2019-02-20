package com.lvt.demo.bean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgeValidator implements ConstraintValidator<Age, String> {

    private long minAge;

    @Override
    public void initialize(Age constraintAnnotation) {
        this.minAge = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
            Date age  = dateFormat.parse(value);
            Date today = new Date();

            Calendar a = getCalendar(age);
            Calendar t = getCalendar(today);

            System.out.println(dateFormat.getDateFormatSymbols().toString());
            return t.get(Calendar.YEAR) - a.get(Calendar.YEAR) >= minAge;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
