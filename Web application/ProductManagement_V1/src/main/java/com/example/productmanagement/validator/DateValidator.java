package com.example.productmanagement.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

public class DateValidator implements ConstraintValidator<DateContraint, Date> {
    @Override
    public void initialize(DateContraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        Calendar dateInCalendar = Calendar.getInstance();
        dateInCalendar.setTime(date);
        return Calendar.getInstance().get(Calendar.MONTH) - dateInCalendar.get(Calendar.MONTH) >= 3;
    }
}
