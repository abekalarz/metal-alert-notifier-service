package com.example.metal_alert_notifier_service.service;

import com.example.metal_alert_notifier_service.dto.template.TemplateRequestDTO;
import com.example.metal_alert_notifier_service.dto.template.TemplateResponseDTO;
import com.example.metal_alert_notifier_service.dto.template.TemplateSummaryResponseDTO;
import com.example.metal_alert_notifier_service.mapper.TemplateMapper;
import com.example.metal_alert_notifier_service.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.metal_alert_notifier_service.mapper.TemplateMapper.*;

@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private PriceValidator priceValidator;

    public TemplateResponseDTO addTemplateOrUpdate(TemplateRequestDTO templateRequestDto) {
        priceValidator.validateRulesPrices(templateRequestDto);
        var savedTemplate = templateRepository.save(mapToEntity(templateRequestDto));
        return mapToResponseDto(savedTemplate);
    }

    public TemplateSummaryResponseDTO getTemplatesSummary() {
        var savedSummaries = templateRepository.findAllBy();
        return mapToSummaryResponseDto(savedSummaries);
    }

    public TemplateResponseDTO getTemplateById(String templateId) {
        var savedTemplate = templateRepository.findById(templateId).orElseThrow();
        return mapToResponseDto(savedTemplate);
    }

    public void deleteTemplateById(String templateId) {
        templateRepository.deleteById(templateId);
    }

    public List<TemplateResponseDTO> getAllTemplates() {
        var allTemplates = templateRepository.findAll();
        return allTemplates.stream().map(TemplateMapper::mapToResponseDto).toList();
    }
}
