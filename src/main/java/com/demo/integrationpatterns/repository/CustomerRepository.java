package com.demo.integrationpatterns.repository;

import com.demo.integrationpatterns.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

  Customer findByName(String name);
}
