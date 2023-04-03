package com.example.fsofttrainingcarparkproject.custom.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.util.Date;

public class BookingDateValidator implements ConstraintValidator<BookingDate, Object> {

    private String beforeFieldName;
    private String afterFieldName;

    @Override
    public void initialize(BookingDate constraintAnnotation) {
        beforeFieldName = constraintAnnotation.before();
        afterFieldName = constraintAnnotation.after();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            final Field beforeDateField = value.getClass().getDeclaredField(beforeFieldName);
            beforeDateField.setAccessible(true);

            final Field afterDateField = value.getClass().getDeclaredField(afterFieldName);
            afterDateField.setAccessible(true);

            final Date beforeDate = (Date) beforeDateField.get(value);
            final Date afterDate = (Date) afterDateField.get(value);

            return beforeDate == null && afterDate == null || beforeDate != null && beforeDate.before(afterDate);
        } catch (final Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
