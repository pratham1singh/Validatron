package com.validatron.validatron.engine.allowedValues;

import com.validatron.validatron.annotations.AllowedValues;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AllowedValuesDelegatingValidator implements ConstraintValidator<AllowedValues, Object> {
    private Map<Class<?>,ConstraintValidator<AllowedValues,?>> constraintValidatorMap ;
    private  AllowedValues allowedValuesAnnotation;
    private String[] allowedValues;

    @Override
    public void initialize(AllowedValues constraintAnnotation) {
        this.constraintValidatorMap = new HashMap();
        this.constraintValidatorMap.put(Integer.class, new AllowedValuesInt());
        this.constraintValidatorMap.put(String.class, new AllowedValuesString());
        this.constraintValidatorMap.put(Long.class, new AllowedValueLong());
        this.constraintValidatorMap.put(Double.class, new AllowedValueDouble());
        this.constraintValidatorMap.put(Float.class, new AllowedValueFloat());
        this.constraintValidatorMap.put(Character.class, new AllowedValuesChar());

        this.allowedValuesAnnotation = constraintAnnotation;
        this.allowedValues = constraintAnnotation.allowedValues();

        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        if(o == null) return true;

        ConstraintValidator<AllowedValues, Object> validator = (ConstraintValidator<AllowedValues, Object>) this.constraintValidatorMap.get(o.getClass());
        if(validator == null) {
            throw new IllegalArgumentException(MessageFormat.format("@AllowedValues not available for {0} type!", o.getClass()));
        }

        validator.initialize(this.allowedValuesAnnotation);
        String msg = MessageFormat.format("Allowed values are {0}", Arrays.toString(this.allowedValues));
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(msg)
                .addConstraintViolation();

        return validator.isValid(o,context);
    }
}
