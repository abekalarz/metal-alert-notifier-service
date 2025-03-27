package com.example.metal_alert_notifier_service.dto.template;

import java.util.Map;

public record RulesDTO(ItemRuleDTO item, Map<String, String> price) {}
