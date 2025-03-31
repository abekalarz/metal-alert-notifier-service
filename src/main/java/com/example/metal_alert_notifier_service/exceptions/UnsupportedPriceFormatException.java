package com.example.metal_alert_notifier_service.exceptions;

public class UnsupportedPriceFormatException extends RuntimeException {
    public UnsupportedPriceFormatException(String message) {
        super(message);
    }
}
