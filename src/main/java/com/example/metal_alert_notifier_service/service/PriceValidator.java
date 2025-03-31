package com.example.metal_alert_notifier_service.service;

import com.example.metal_alert_notifier_service.dto.price.PriceRequestDTO;
import com.example.metal_alert_notifier_service.dto.template.TemplateRequestDTO;
import com.example.metal_alert_notifier_service.exceptions.UnsupportedPriceFormatException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

@Service
public class PriceValidator {
    private static final Pattern PRICE_PATTERN = Pattern.compile("^\\d+(\\.\\d{1,2})?$");

    private static final Logger logger = LoggerFactory.getLogger(PriceValidator.class);

    public void validateRulesPrices(TemplateRequestDTO templateRequestDto) {
        var priceRules = templateRequestDto.rules().price();
        priceRules.forEach((priceOperator, priceValue) -> {
            if (!isValidPrice(priceValue)) {
                var error = String.format("For given template request [%s], some price rules includes price values in wrong format. Please provide valid price format [0.00]", templateRequestDto);
                logger.error(error);
                throw new UnsupportedPriceFormatException(error);
            }
        });
    }

    public void validatePriceInNotificationRequest(PriceRequestDTO priceRequestDTO) {
        if (!isValidPrice(priceRequestDTO.price())) {
            var error = String.format("For given price request [%s], price is in incorrect format. Please provide valid price format [0.00]", priceRequestDTO);
            logger.error(error);
            throw new UnsupportedPriceFormatException(error);
        }
    }

    private static boolean isValidPrice(String price) {
        return price != null && PRICE_PATTERN.matcher(price).matches();
    }
}
