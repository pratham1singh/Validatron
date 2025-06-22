package com.validatron.validatron.engine.allowedValues;

import com.validatron.validatron.annotations.AllowedValues;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class AllowedValuesInt implements ConstraintValidator<AllowedValues, Integer> {
    private String[] allowedValues;

    @Override
    public void initialize(AllowedValues constraintAnnotation) {
        this.allowedValues = constraintAnnotation.allowedValues();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer i, ConstraintValidatorContext context) {
        return Arrays.asList(this.allowedValues).contains(String.valueOf(i));
    }
}
