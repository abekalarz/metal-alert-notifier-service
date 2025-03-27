package com.example.metal_alert_notifier_service.controller;

import com.example.metal_alert_notifier_service.dto.template.TemplateResponseDTO;
import com.example.metal_alert_notifier_service.dto.price.PriceRequestDTO;
import com.example.metal_alert_notifier_service.service.PriceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/new-price")
@CrossOrigin(
        origins = "http://localhost:8000",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS},
        allowedHeaders = "*"
)
public class MetalPriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping
    public TemplateResponseDTO setNewPrice(
            @RequestBody @Valid PriceRequestDTO priceRequestDTO
    ) {
        return priceService.setNewPriceToFireSignal(priceRequestDTO);
    }

}
