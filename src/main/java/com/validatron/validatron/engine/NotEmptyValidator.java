package com.validatron.validatron.engine;

import com.validatron.validatron.annotations.NotEmpty;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class NotEmptyValidator implements ConstraintValidator<NotEmpty, Object> {
    @Override
    public void initialize(NotEmpty constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object field, ConstraintValidatorContext constraintValidatorContext) {
        if (field == null) return false;

        if(field instanceof String){
            return !((String) field).isEmpty();
        } else if (field instanceof Collection<?>) {
            return !((Collection<?>) field).isEmpty();
        } else if (field instanceof Object[]) {
            return ((Object[]) field).length > 0;
        } else if (field instanceof Map<?,?>) {
            return !((Map<?,?>) field).isEmpty();
        }
        return false;
    }
}
