package com.example.metal_alert_notifier_service.dto.price;

import jakarta.validation.constraints.NotBlank;

public record PriceRequestDTO(
        @NotBlank(message = "Item type is mandatory")
        String itemType,
        @NotBlank(message = "Price is mandatory")
        String price
) {}
