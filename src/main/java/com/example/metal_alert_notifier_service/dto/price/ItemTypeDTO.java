package com.example.metal_alert_notifier_service.dto.price;

public enum ItemTypeDTO {
    GOLD,
    SILVER,
    PLATINUM;

    public static ItemTypeDTO select(String requestedName) {
        return switch (requestedName) {
            case "gold" -> GOLD;
            case "silver" -> SILVER;
            case "platinum" -> PLATINUM;
            default -> throw new IllegalArgumentException("Unsupported metal type: " + requestedName + ". Supported are: " + ItemTypeDTO.values());
        };
    }
}
