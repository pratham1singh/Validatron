package com.validatron.validatron.engine.allowedValues;

import com.validatron.validatron.annotations.AllowedValues;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class AllowedValueFloat implements ConstraintValidator<AllowedValues, Float> {
    private String[] allowedValues;

    @Override
    public void initialize(AllowedValues constraintAnnotation) {
        this.allowedValues = constraintAnnotation.allowedValues();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Float f, ConstraintValidatorContext context) {
        return Arrays.asList(this.allowedValues).contains(String.valueOf(f));
    }
}
