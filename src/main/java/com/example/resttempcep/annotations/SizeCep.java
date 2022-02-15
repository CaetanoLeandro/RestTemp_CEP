package com.example.resttempcep.annotations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ValidationCep.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface SizeCep {
    String message() default "O Mínimo de caracteres deve ser 8";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
