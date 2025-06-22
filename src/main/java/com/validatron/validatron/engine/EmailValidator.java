package com.validatron.validatron.engine;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.validatron.validatron.annotations.Email;

public class EmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public void initialize(Email constraintAnnotation) {}

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(email == null) return true;

        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}

