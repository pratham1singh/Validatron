package com.validatron.validatron.engine.allowedValues;

import com.validatron.validatron.annotations.AllowedValues;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class AllowedValueLong implements ConstraintValidator<AllowedValues, Long> {
    private String[] allowedValues;

    @Override
    public void initialize(AllowedValues constraintAnnotation) {
        this.allowedValues = constraintAnnotation.allowedValues();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long l, ConstraintValidatorContext context) {
        return Arrays.asList(this.allowedValues).contains(String.valueOf(l));
    }
}
