package com.validatron.validatron.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
    String message() default "{NotNull.default}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
