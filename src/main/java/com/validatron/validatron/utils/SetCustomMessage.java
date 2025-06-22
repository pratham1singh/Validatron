package com.validatron.validatron.utils;

import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

@Service
public class SetCustomMessage {

    public void setErrorMessage(ConstraintValidatorContext context, String message) {
        context.getDefaultConstraintMessageTemplate();
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
        return;
    }
}
