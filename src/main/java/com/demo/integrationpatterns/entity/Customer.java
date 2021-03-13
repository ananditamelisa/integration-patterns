package com.demo.integrationpatterns.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = Customer.COLLECTION_NAME)
public class Customer {

  public static final String COLLECTION_NAME = "CUSTOMER";

  @Id
  private String id;
  private String name;
  private String address;
  private String phoneNumber;
  private String email;
}
