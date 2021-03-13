package com.demo.integrationpatterns.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "integration.patterns.mongodb")
@Data
public class MongoProperties {

  private String host;
  private String database;
}
