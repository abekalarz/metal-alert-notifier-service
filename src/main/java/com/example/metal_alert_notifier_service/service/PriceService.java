package com.example.metal_alert_notifier_service.service;

import com.example.metal_alert_notifier_service.dto.price.PriceRequestDTO;
import com.example.metal_alert_notifier_service.dto.template.TemplateResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private NotificationService notificationService;

    public TemplateResponseDTO setNewPriceToFireSignal(@Valid PriceRequestDTO priceRequestDTO) {
        var allTemplates = templateService.getAllTemplates();
        var allRules = allTemplates.stream().map(TemplateResponseDTO::rules);

        return null;
    }

}
