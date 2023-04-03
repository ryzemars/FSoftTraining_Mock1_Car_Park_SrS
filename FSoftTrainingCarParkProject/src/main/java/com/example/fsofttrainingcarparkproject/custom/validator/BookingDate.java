package com.example.fsofttrainingcarparkproject.custom.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = BookingDateValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
public @interface BookingDate {
    String message() default "note mặc định: sai ngày";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String before();

    String after();
}
