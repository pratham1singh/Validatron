package com.validatron.validatron.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowedValues {
    String message() default "{AllowedValues.default}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String[] allowedValues();
}
