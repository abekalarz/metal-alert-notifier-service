package com.example.metal_alert_notifier_service.controller;

import com.example.metal_alert_notifier_service.dto.template.TemplateRequestDTO;
import com.example.metal_alert_notifier_service.dto.template.TemplateResponseDTO;
import com.example.metal_alert_notifier_service.dto.template.TemplateSummaryResponseDTO;
import com.example.metal_alert_notifier_service.service.TemplateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/templates")
@CrossOrigin(
        origins = "http://localhost:8000",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS},
        allowedHeaders = "*"
)
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PostMapping
    public TemplateResponseDTO addOrUpdate(
            @RequestBody @Valid TemplateRequestDTO templateRequestDto
    ) {
        return templateService.addTemplateOrUpdate(templateRequestDto);
    }

    @GetMapping
    public TemplateSummaryResponseDTO getSummary() {
        return templateService.getTemplatesSummary();
    }

    @GetMapping("/{templateId}")
    public TemplateResponseDTO getTemplate(@PathVariable String templateId) {
        return templateService.getTemplateById(templateId);
    }

    @DeleteMapping("/{templateId}")
    public void deleteTemplate(@PathVariable String templateId) {
        templateService.deleteTemplateById(templateId);
    }

}
