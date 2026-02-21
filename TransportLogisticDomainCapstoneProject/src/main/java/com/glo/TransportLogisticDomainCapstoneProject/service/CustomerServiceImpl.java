package com.glo.TransportLogisticDomainCapstoneProject.service;

import com.glo.TransportLogisticDomainCapstoneProject.domain.Customer;
import com.glo.TransportLogisticDomainCapstoneProject.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        if (customerRepository.findById(customer.getCust_id()).isEmpty()) {
            // we have no customer with this ID => add it
            customerRepository.save(customer);
            LOGGER.info("Customer added successfully: " + customer.toString());
            return;
        }
        // else, we already have a customer with this ID
        LOGGER.error("Customer with id {} already exists", customer.getCust_id());
    }

    public void updateCustomer(Customer customer) {
        Optional<Customer> foundCustomer = customerRepository.findById(customer.getCust_id());
        if (foundCustomer.isEmpty()) {
            // we don't have a customer with that ID
            LOGGER.error("Customer with id {} not found", customer.getCust_id());
        } else {
            customerRepository.save(customer);
            LOGGER.info("Customer updated successfully: " + customer.toString());
        }
    }

    public Customer getCustomerById(int customerId) {
        Optional<Customer> foundCustomer = customerRepository.findById(customerId);
        if (foundCustomer.isEmpty()) {
            LOGGER.error("Customer with id {} not found", customerId);
            return null;
        }
        return foundCustomer.get();
    }
}
