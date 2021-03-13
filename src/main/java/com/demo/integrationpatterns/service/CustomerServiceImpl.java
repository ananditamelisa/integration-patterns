package com.demo.integrationpatterns.service;

import com.demo.integrationpatterns.entity.Customer;
import com.demo.integrationpatterns.publisher.KafkaTopicPublisher;
import com.demo.integrationpatterns.repository.CustomerRepository;
import com.demo.integrationpatterns.request.CustomerAddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private KafkaTopicPublisher kafkaTopicPublisher;

  @Override
  public void changeCustomerAddress(CustomerAddressRequest request) {
    Customer customer = customerRepository.findByName(request.getName());
    customer.setAddress(request.getNewAddress());
    customerRepository.save(customer);
    kafkaTopicPublisher.publish(request, "integration.patterns.customer.address.update");
  }
}
