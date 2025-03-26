package com.example.metal_alert_notifier_service.repository;

import com.example.metal_alert_notifier_service.model.TemplateEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TemplateRepository extends MongoRepository<TemplateEntity, String> {
}
