package com.example.metal_alert_notifier_service.controller;

import com.example.metal_alert_notifier_service.dto.TemplateRequestDTO;
import com.example.metal_alert_notifier_service.dto.TemplateResponseDTO;
import com.example.metal_alert_notifier_service.dto.TemplateSummaryResponseDTO;
import com.example.metal_alert_notifier_service.service.TemplateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api/v1/templates")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PostMapping
    public TemplateResponseDTO add(
            @RequestBody @Valid TemplateRequestDTO templateRequestDto
    ) {
        return templateService.addTemplate(templateRequestDto);
    }

    @GetMapping
    public TemplateSummaryResponseDTO getSummary() {
        return templateService.getTemplatesSummary();
    }

    @GetMapping("/{templateId}")
    public TemplateResponseDTO getTemplate(@PathVariable String templateId) {
        return templateService.getTemplateById(templateId);
    }

//    @PutMapping("/{productId}/{reporter}")
//    public ComplaintResponse updateComplaintContent(@PathVariable String productId,
//                                                    @PathVariable String reporter,
//                                                    @RequestBody @Valid ComplaintUpdateRequest newContent) {
//        return complaintService.updateContent(productId, reporter, newContent.getContent());
//    }
//
//    @GetMapping("/{productId}/{reporter}")
//    public ComplaintResponse getComplaint(@PathVariable String productId,
//                                          @PathVariable String reporter) {
//        return complaintService.getComplaint(productId, reporter);
//    }
//
//    @GetMapping
//    public Page<ComplaintResponse> getAll(@PageableDefault(page = 0, size = 5, sort = "productId") Pageable pageable) {
//        return complaintService.getAllComplaints(pageable);
//    }
}
