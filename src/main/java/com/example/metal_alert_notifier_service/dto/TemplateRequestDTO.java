package com.example.metal_alert_notifier_service.dto;

import jakarta.annotation.Nullable;

import java.util.List;

//TODO Add Validation annotations !
public record TemplateRequestDTO(
        @Nullable
        String id,
        String title,
        String content,
        List<String> recipients,
        RulesDTO rules
) {}
