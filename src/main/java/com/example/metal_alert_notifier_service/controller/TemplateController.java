package com.example.metal_alert_notifier_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    private TemplateService templateService;

    @PostMapping
    public TemplateResponseDTO addOrUpdate(
            @RequestBody @Valid TemplateRequestDTO templateRequestDto
    ) {
        logger.info("Got new template request: {}. Saving or updating (if exists) started...", templateRequestDto);
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
        logger.info("Got new template delete request for templateId: {}. Deleting started...", templateId);
        templateService.deleteTemplateById(templateId);
    }

}
