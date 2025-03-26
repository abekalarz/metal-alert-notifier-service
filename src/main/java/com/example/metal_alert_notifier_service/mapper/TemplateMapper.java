package com.example.metal_alert_notifier_service.mapper;

import com.example.metal_alert_notifier_service.dto.RulesDTO;
import com.example.metal_alert_notifier_service.dto.TemplateRequestDTO;
import com.example.metal_alert_notifier_service.model.TemplateEntity;

public class TemplateMapper {

    public static TemplateEntity mapToEntity(TemplateRequestDTO dto) {
        return new TemplateEntity(
                null,
                dto.title(),
                dto.content(),
                dto.recipients(),
                mapRules(dto.rules())
        );
    }

    private static TemplateEntity.Rules mapRules(RulesDTO rulesDTO) {
        return new TemplateEntity.Rules(
                new TemplateEntity.ItemRule(
                        rulesDTO.item().operator(),
                        rulesDTO.item().value()
                ),
                rulesDTO.price()
        );
    }
}
