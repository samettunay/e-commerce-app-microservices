package com.samet.ecommerce.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.samet.ecommerce.exception.CustomerNotFoundException;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    
    public String createCustomer(CustomerRequest request) {
        var customer = repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest request) {
        var customer = repository.findById(request.id())
            .orElseThrow(() -> new CustomerNotFoundException(
                String.format("Cannot updated customer:: No customer found for id: %s", request.id())
            ));

        mergerCustomer(customer, request);
        repository.save(customer);
    }

    private void mergerCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.lastname())) {
            customer.setLastname(request.lastname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll()
            .stream()
            .map(mapper::fromCustomer)
            .collect(Collectors.toList());
    }

    public boolean existsById(String customerId) {
        return repository.findById(customerId).isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return repository.findById(customerId)
            .map(mapper::fromCustomer)
            .orElseThrow(() -> new CustomerNotFoundException(
                String.format("Cannot find customer:: No customer found for id: %s", customerId)
            ));
    }

    public void deleteCustomer(String customerId) {
        if (!existsById(customerId)) {
            throw new CustomerNotFoundException(
                String.format("Cannot delete customer:: No customer found for id: %s", customerId)
            );
        }
        repository.deleteById(customerId);
    }
}
