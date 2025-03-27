package com.example.metal_alert_notifier_service.dto.price;

public enum ItemType {
    GOLD("gold"),
    SILVER("silver"),
    PLATINUM("platinum");

    private final String fullName;

    ItemType(String symbol) {
        this.fullName = symbol;
    }
    public String getFullName() {
        return fullName;
    }
}
