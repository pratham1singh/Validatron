package com.validatron.validatron.engine;

import com.validatron.validatron.annotations.NotNull;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotNullValidator implements ConstraintValidator<NotNull, Object> {
    @Override
    public void initialize(NotNull constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        return o!= null;
    }
}
