package com.example.metal_alert_notifier_service.dto;

import java.util.List;

//TODO Add Validation annotations !
public record TemplateRequestDTO(
        String title,
        String content,
        List<String> recipients,
        RulesDTO rules
) {}
