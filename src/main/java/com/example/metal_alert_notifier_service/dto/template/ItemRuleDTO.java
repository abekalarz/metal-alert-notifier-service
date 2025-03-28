package com.example.metal_alert_notifier_service.dto.template;

import jakarta.validation.constraints.NotBlank;

public record ItemRuleDTO(
        @NotBlank(message = "Item rule operator is mandatory")
        String operator,
        @NotBlank(message = "Item rule value is mandatory")
        String value
) {}
