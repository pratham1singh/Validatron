package com.validatron.validatron.engine.allowedValues;

import com.validatron.validatron.annotations.AllowedValues;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class AllowedValuesString implements ConstraintValidator<AllowedValues, String> {
    private String[] allowedValues;

    @Override
    public void initialize(AllowedValues constraintAnnotation) {
        this.allowedValues = constraintAnnotation.allowedValues();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s!=null && Arrays.asList(this.allowedValues).contains(s);
    }
}
