package com.validatron.validatron.engine;

import com.validatron.validatron.annotations.FieldsMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;

public class FieldsMatchValidator implements ConstraintValidator<FieldsMatch, Object> {
    private String[] fields;

    @Override
    public void initialize(FieldsMatch constraintAnnotation) {
        this.fields = constraintAnnotation.fields();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        BeanWrapperImpl wrapper = new BeanWrapperImpl(o);
        HashSet<String> set = new HashSet<>();

        Arrays.stream(this.fields)
                .map(wrapper::getPropertyValue)
                .map(value -> (String) value)
                .forEach(set::add);

        if (set.contains(null)) {
            this.setMessage(context, MessageFormat.format("Following fields {0} cannot be null", Arrays.toString(this.fields)));
            return false;
        }
        this.setMessage(context, MessageFormat.format("All following fields {0} must have same value", Arrays.toString(this.fields)));

        return set.size() == 1;
    }

    private void setMessage(ConstraintValidatorContext context, String msg) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
    }
}
