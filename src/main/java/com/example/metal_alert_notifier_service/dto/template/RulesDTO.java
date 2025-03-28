package com.example.metal_alert_notifier_service.dto.template;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.Map;

public record RulesDTO(
        @Valid
        ItemRuleDTO item,
        @Size(min = 1, message = "Price rules must contain at least one item.")
        Map<String, String> price
) {
}
