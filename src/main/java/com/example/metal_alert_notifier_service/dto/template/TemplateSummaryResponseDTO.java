package com.example.metal_alert_notifier_service.dto.template;

import java.util.List;

public record TemplateSummaryResponseDTO(
        List<TemplateSummaryDTO> summary
) {
    public record TemplateSummaryDTO(
            String id,
            String title
    ) {
    }
}
