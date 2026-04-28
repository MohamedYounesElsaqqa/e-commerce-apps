package com.gohar.customer.customer;

import com.gohar.customer.customer.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServices {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    public String createCustomer(CustomerRequest request){
        var customer = customerRepository.save(customerMapper.toCustomer(request));
        return customer.getId();
    }
    public void updateCustomer(CustomerRequest request)  {
       var customer = customerRepository.findById(request.id())
               .orElseThrow(() -> new CustomerNotFoundException(
                       String.format("not found Customer:: no Customer found the id:: %s",request.id())));
       mergerCustomer(customer,request);
       customerRepository.save(customer);
    }
    public List<CustomerResponse> getAllCustomer()  {
       return customerRepository.findAll()
               .stream()
               .map(customerMapper::fromCustomer)
               .collect(Collectors.toList());
    }
    public Boolean exitsById(String customerId)  {
        return customerRepository.findById(customerId).isPresent();
    }
    public CustomerResponse findById(String customerId)  {
        return customerRepository.findById(customerId)
                .map(customerMapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found:: %s",customerId)));
    }
    public void deleteCustomer(String customerId)  {
        customerRepository.deleteById(customerId);
    }

    private void mergerCustomer(Customer customer, CustomerRequest request) {
        if(StringUtils.isNotBlank(request.name())){
            customer.setName(request.name());
        }
        if(StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if(request.address() !=null){
            customer.setAddress(request.address());
        }
    }
}
