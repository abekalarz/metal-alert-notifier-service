package com.example.metal_alert_notifier_service.dto.price;

import java.math.BigDecimal;

public enum PriceOperatorDTO {
    EQ, GTE, GT, LT, LTE;

    public static boolean isApplicableFor(String operator, BigDecimal savedPrice, BigDecimal requestedPrice) {
        var comparison = requestedPrice.compareTo(savedPrice);
        return switch (PriceOperatorDTO.valueOf(operator.toUpperCase())) {
            case EQ  -> comparison == 0;
            case GTE -> comparison >= 0;
            case GT  -> comparison > 0;
            case LT  -> comparison < 0;
            case LTE -> comparison <= 0;
        };
    }
}
