package com.disid.restful.web.customer.api;

import com.disid.restful.model.Customer;
import com.disid.restful.model.CustomerSearchForm;
import com.disid.restful.service.api.CustomerService;

import io.springlets.data.domain.GlobalSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/customers/search", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomersSearchJsonController {

  public CustomerService customerService;

  @Autowired
  public CustomersSearchJsonController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/byFirstNameLastName")
  public ResponseEntity<Page<Customer>> findByFirstNameLastName(CustomerSearchForm formBean,
      GlobalSearch globalSearch, Pageable pageable) {
    Page<Customer> customers =
        customerService.findByFirstNameLastName(formBean, globalSearch, pageable);
    return ResponseEntity.status(HttpStatus.FOUND).body(customers);
  }

}
