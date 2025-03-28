package com.example.metal_alert_notifier_service.repository;

import com.example.metal_alert_notifier_service.model.TemplateEntity;
import com.example.metal_alert_notifier_service.model.TemplateSummary;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TemplateRepository extends MongoRepository<TemplateEntity, String> {

    List<TemplateSummary> findAllBy();

}
