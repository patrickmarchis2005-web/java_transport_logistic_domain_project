package com.glo.TransportLogisticDomainCapstoneProject.service;

import com.glo.TransportLogisticDomainCapstoneProject.domain.Customer;

public interface CustomerService {
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public Customer getCustomerById(int customerId);
}
