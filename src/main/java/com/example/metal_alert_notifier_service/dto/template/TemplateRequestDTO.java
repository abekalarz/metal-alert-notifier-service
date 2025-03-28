package com.example.metal_alert_notifier_service.dto.template;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record TemplateRequestDTO(
        @Nullable
        String id,
        @NotBlank(message = "Title is mandatory")
        String title,
        @NotBlank(message = "Content is mandatory")
        String content,
        @Size(min = 1, message = "Recipient list must contain at least one item.")
        List<@Email(message = "Recipient has wrong e-mail format") @NotBlank(message = "No recipient can be empty") String> recipients,
        @Valid
        RulesDTO rules
) {
}
