package com.demo.integrationpatterns.controller;

import com.demo.integrationpatterns.request.CustomerAddressRequest;
import com.demo.integrationpatterns.response.RestBaseResponse;
import com.demo.integrationpatterns.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @PutMapping(path = "/customer/address",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public RestBaseResponse readSentNotificationByFilter(
      @RequestBody CustomerAddressRequest request) {
    customerService.changeCustomerAddress(request);
    return RestBaseResponse.builder().success(true).build();
  }
}
