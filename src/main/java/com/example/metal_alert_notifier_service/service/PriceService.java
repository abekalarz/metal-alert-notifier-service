package com.example.metal_alert_notifier_service.service;

import com.example.metal_alert_notifier_service.dto.price.ItemOperatorDTO;
import com.example.metal_alert_notifier_service.dto.price.ItemTypeDTO;
import com.example.metal_alert_notifier_service.dto.price.PriceOperatorDTO;
import com.example.metal_alert_notifier_service.dto.price.PriceRequestDTO;
import com.example.metal_alert_notifier_service.dto.template.ItemRuleDTO;
import com.example.metal_alert_notifier_service.dto.template.TemplateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class PriceService {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private NotificationService notificationService;

    public void triggerNotificationsForMatchingTemplates(PriceRequestDTO priceRequestDTO) {
        var requestedItem = ItemTypeDTO.select(priceRequestDTO.itemType()).name().toUpperCase();
        var requestedPrice = new BigDecimal(priceRequestDTO.price());

        var matchingTemplates = findMatchingTemplates(requestedItem, requestedPrice);

        sendNotifications(matchingTemplates);
    }

    private void sendNotifications(List<TemplateResponseDTO> matchingTemplates) {
        matchingTemplates.forEach(matchingTemplate -> {
            notificationService.sendNotification(
                    matchingTemplate.title(), matchingTemplate.content(), matchingTemplate.recipients()
            );
        });
    }

    private List<TemplateResponseDTO> findMatchingTemplates(String requestedItem, BigDecimal requestedPrice) {
        return templateService.getAllTemplates().stream().filter(template -> {
            ItemRuleDTO itemRule = template.rules().item();
            Map<String, String> priceRules = template.rules().price();

            boolean itemCondition = ItemOperatorDTO.isApplicableFor(itemRule.operator(), itemRule.value(), requestedItem);

            return itemCondition && priceRules.entrySet().stream().allMatch(priceRule -> {
                var operator = priceRule.getKey();
                var price = new BigDecimal(priceRule.getValue());
                return PriceOperatorDTO.isApplicableFor(operator, price, requestedPrice);
            });
        }).toList();
    }


}
