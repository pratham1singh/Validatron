package com.validatron.validatron.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmpty {
    String message() default "{NotEmpty.default}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
