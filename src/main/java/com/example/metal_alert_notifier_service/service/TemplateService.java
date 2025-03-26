package com.example.metal_alert_notifier_service.service;

import com.example.metal_alert_notifier_service.dto.TemplateRequestDTO;
import com.example.metal_alert_notifier_service.dto.TemplateResponseDTO;
import com.example.metal_alert_notifier_service.dto.TemplateSummaryResponseDTO;
import com.example.metal_alert_notifier_service.repository.TemplateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.metal_alert_notifier_service.mapper.TemplateMapper.*;

@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    public TemplateResponseDTO addTemplate(@Valid TemplateRequestDTO templateRequestDto) {
        var savedTemplate = templateRepository.save(mapToEntity(templateRequestDto));
        return mapToResponseDto(savedTemplate);
    }

    public TemplateSummaryResponseDTO getTemplatesSummary() {
        var savedSummaries = templateRepository.findAllBy();
        return mapToSummaryResponseDto(savedSummaries);}

    public TemplateResponseDTO getTemplateById(String templateId) {
        var savedTemplate = templateRepository.findById(templateId).orElseThrow();
        return mapToResponseDto(savedTemplate);
    }

    public void deleteTemplateById(String templateId) {
        templateRepository.deleteById(templateId);
    }
}
