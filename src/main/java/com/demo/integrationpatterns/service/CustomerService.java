package com.demo.integrationpatterns.service;

import com.demo.integrationpatterns.request.CustomerAddressRequest;

public interface CustomerService {

  void changeCustomerAddress(CustomerAddressRequest request);
}
