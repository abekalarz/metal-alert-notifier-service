package com.example.metal_alert_notifier_service.dto;

import java.util.List;

//TODO Add Validation annotations !
public record TemplateRequestDTO(
        String title,
        String content,
        List<String> recipients,
        RulesDTO rules
) {}

// public record RulesDTO(ItemRuleDTO item, Map<String, String> price) {}

// public record ItemRuleDTO(String operator, String value) {}