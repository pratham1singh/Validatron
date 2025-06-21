package com.validatron.validatron.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {
    String message() default "Field cannot be blank!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
