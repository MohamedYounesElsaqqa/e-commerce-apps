package com.gohar.customer.customer;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerServices customerServices;

    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }
    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        return ResponseEntity.ok(customerServices.createCustomer(customerRequest));
    }
    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        customerServices.updateCustomer(customerRequest);
        return ResponseEntity.accepted().build();
    }
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){

        return ResponseEntity.ok(customerServices.getAllCustomer());
    }
    @GetMapping("/exits/{customer-id}")
    public ResponseEntity<Boolean> exitsById(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(customerServices.exitsById(customerId));
    }

    @GetMapping("/exits/{customer-id}")
    public ResponseEntity<?> findById(@PathVariable("customer-id") String customerId){
        customerServices.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }
}
