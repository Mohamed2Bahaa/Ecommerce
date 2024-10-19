package com.mohamed.ecommerce.customer;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private  CustomerService service;

    @PostMapping
    public ResponseEntity<String> createCustomer(
        @RequestBody @Valid CustomerRequest request
    )
    {
        return ResponseEntity.ok(service.createCustomer(request));
    }
    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest request)
    {
        service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll()
    {
        return ResponseEntity.ok(service.findAllCustomers());
    }

    @GetMapping("/exits/{customer-id}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable("customer-id")
            String customerId
    )
    {
        return ResponseEntity.ok(service.existsById(customerId));
    }

    @GetMapping("/exits/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(
            @PathVariable("customer-id")
            String customerId
    )
    {
        return ResponseEntity.ok(service.findById(customerId));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void>delete
            (  @PathVariable("customer-id")
               String customerId)
    {
        service.deleteCustomer(customerId);
        return  ResponseEntity.accepted().build();
    }
}
