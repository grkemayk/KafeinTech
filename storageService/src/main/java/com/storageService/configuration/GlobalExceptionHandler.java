package com.storageService.configuration;

import org.commonModule.component.ValidationExceptionHandling;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Import(ValidationExceptionHandling.class)
public class GlobalExceptionHandler {
}
