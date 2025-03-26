package com.example.metal_alert_notifier_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.Map;

@Document(collection = "templates")
public class TemplateEntity {

    @Id
    private String id;

    private String title;

    private String content;

    private List<String> recipients;

    private Rules rules;

    public TemplateEntity() {
    }

    public TemplateEntity(String id, String title, String content, List<String> recipients, Rules rules) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.recipients = recipients;
        this.rules = rules;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }

    public static class Rules {
        private ItemRule item;
        private Map<String, String> price;

        public Rules() {
        }

        public Rules(ItemRule item, Map<String, String> price) {
            this.item = item;
            this.price = price;
        }

        public ItemRule getItem() {
            return item;
        }

        public void setItem(ItemRule item) {
            this.item = item;
        }

        public Map<String, String> getPrice() {
            return price;
        }

        public void setPrice(Map<String, String> price) {
            this.price = price;
        }
    }

    public static class ItemRule {
        private String operator;
        private String value;

        public ItemRule() {
        }

        public ItemRule(String operator, String value) {
            this.operator = operator;
            this.value = value;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
