package com.example.metal_alert_notifier_service.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

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

        logger.warn("Validation failed for one of the input requests: {}", errors);

        return handleExceptionInternal(
                exception, apiError, headers, apiError.status(), request
        );
    }

    @ExceptionHandler(UnsupportedMetalTypeException.class)
    public ResponseEntity<ApiError> handleUnsupportedMetalType(UnsupportedMetalTypeException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), List.of("Unsupported metal type"));

        logger.warn("Invalid metal type provided: value is not supported.: {}", apiError);

        return new ResponseEntity<>(apiError, apiError.status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), List.of("Unexpected error occurred"));

        logger.error("Internal Server Error occurred: {}", apiError);

        return new ResponseEntity<>(apiError, apiError.status);
    }

    public record ApiError(HttpStatusCode status, String message, List<String> errors) {
    }
}
