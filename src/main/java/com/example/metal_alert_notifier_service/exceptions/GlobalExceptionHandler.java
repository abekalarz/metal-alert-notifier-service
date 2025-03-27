package com.example.metal_alert_notifier_service.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<String> errors = exception.getBindingResult().getAllErrors().stream()
                .map(error ->
                        switch (error) {
                            case FieldError fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage();
                            default -> error.getObjectName() + ": " + error.getDefaultMessage();
                        })
                .toList();

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), errors);

        return handleExceptionInternal(
                exception, apiError, headers, apiError.status(), request
        );
    }

    public record ApiError(HttpStatusCode status, String message, List<String> errors) {
    }
}
