package com.example.metal_alert_notifier_service.mapper;

import com.example.metal_alert_notifier_service.dto.ItemRuleDTO;
import com.example.metal_alert_notifier_service.dto.RulesDTO;
import com.example.metal_alert_notifier_service.dto.TemplateRequestDTO;
import com.example.metal_alert_notifier_service.dto.TemplateResponseDTO;
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

    public static TemplateResponseDTO mapToResponseDto(TemplateEntity entity) {
        return new TemplateResponseDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getRecipients(),
                mapRulesDto(entity.getRules())
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

    private static RulesDTO mapRulesDto(TemplateEntity.Rules rules) {
        return new RulesDTO(
                new ItemRuleDTO(
                        rules.getItem().getOperator(),
                        rules.getItem().getValue()
                ),
                rules.getPrice()
        );
    }
}
