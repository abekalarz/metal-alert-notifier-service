package com.example.metal_alert_notifier_service.dto.price;

import com.example.metal_alert_notifier_service.exceptions.UnsupportedMetalTypeException;

import java.util.Arrays;

public enum ItemTypeDTO {
    GOLD,
    SILVER,
    PLATINUM;

    public static ItemTypeDTO select(String requestedName) {
        return switch (requestedName) {
            case "gold" -> GOLD;
            case "silver" -> SILVER;
            case "platinum" -> PLATINUM;
            default -> throw new UnsupportedMetalTypeException("Unsupported metal type: [" + requestedName + "]. Supported are: " + Arrays.toString(ItemTypeDTO.values()));
        };
    }
}
