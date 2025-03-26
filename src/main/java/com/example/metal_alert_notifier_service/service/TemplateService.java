package com.example.metal_alert_notifier_service.service;

import com.example.metal_alert_notifier_service.dto.TemplateRequestDTO;
import com.example.metal_alert_notifier_service.dto.TemplateResponseDTO;
import com.example.metal_alert_notifier_service.repository.TemplateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.metal_alert_notifier_service.mapper.TemplateMapper.mapToEntity;

@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    public TemplateResponseDTO addTemplate(@Valid TemplateRequestDTO templateRequestDto) {
        mapToEntity(templateRequestDto);

        templateRepository.save(mapToEntity(templateRequestDto));
        return null;
    }
}
