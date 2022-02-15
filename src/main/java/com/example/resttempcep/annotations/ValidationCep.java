package com.example.resttempcep.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

    public class ValidationCep implements ConstraintValidator<SizeCep, String> {

        public void initialize(SizeCep constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value.length() == 8;
        }
    }
