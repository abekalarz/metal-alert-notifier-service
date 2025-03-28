package com.example.metal_alert_notifier_service.controller;

import com.example.metal_alert_notifier_service.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(MetalPriceController.class);

    @Autowired
    private PriceService priceService;

    @PostMapping
    public void setNewPrice(
            @RequestBody @Valid PriceRequestDTO priceRequestDTO
    ) {
        logger.info("Got new metal price request: {}. Triggering notifications for matching templates...", priceRequestDTO);
        priceService.triggerNotificationsForMatchingTemplates(priceRequestDTO);
    }

}
