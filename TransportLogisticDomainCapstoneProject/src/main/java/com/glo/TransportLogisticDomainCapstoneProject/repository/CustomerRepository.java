package com.glo.TransportLogisticDomainCapstoneProject.repository;

import com.glo.TransportLogisticDomainCapstoneProject.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
