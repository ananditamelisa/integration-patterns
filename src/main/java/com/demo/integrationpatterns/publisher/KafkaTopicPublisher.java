package com.demo.integrationpatterns.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class KafkaTopicPublisher {

  @Autowired(required = false)
  private KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  public void publish(Object objectToPublish, String topicName) {
    Map<String, Object> kafkaHeaders = new HashMap<>();
    kafkaHeaders.put(KafkaHeaders.TOPIC, topicName);
    kafkaTemplate.send(buildMessage(objectToPublish, kafkaHeaders));
    log.warn("Kafka topic {} is successfully published", topicName);
  }

  private Message<String> buildMessage(Object objectToPublish, Map<String, Object> headers) {
    return new Message<String>() {

      @Override
      public String getPayload() {
        try {
          return objectMapper.writeValueAsString(objectToPublish);
        } catch (JsonProcessingException e) {
          log.error("Failed to write kafka object to string");
          return Strings.EMPTY;
        }
      }

      @Override
      public MessageHeaders getHeaders() {
        return new MessageHeaders(headers);
      }
    };
  }
}
