package com.example.metal_alert_notifier_service.dto;

import java.util.Map;

public record RulesDTO(ItemRuleDTO item, Map<String, String> price) {}
