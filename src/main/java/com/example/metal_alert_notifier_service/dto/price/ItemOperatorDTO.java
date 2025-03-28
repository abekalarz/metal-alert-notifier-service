package com.example.metal_alert_notifier_service.dto.price;

import java.util.Objects;

public enum ItemOperatorDTO {
    IS, IS_NOT;

    public static boolean isApplicableFor(String requestedOperator, String savedItem, String requestedItem) {
        return switch (ItemOperatorDTO.valueOf(requestedOperator)) {
            case IS -> Objects.equals(savedItem, requestedItem);
            case IS_NOT -> !Objects.equals(savedItem, requestedItem);
        };
    }
}
