package com.example.metal_alert_notifier_service.dto;

import java.util.List;

public record TemplateResponseDTO(
        String id,
        String title,
        String content,
        List<String> recipients,
        RulesDTO rules
) {}