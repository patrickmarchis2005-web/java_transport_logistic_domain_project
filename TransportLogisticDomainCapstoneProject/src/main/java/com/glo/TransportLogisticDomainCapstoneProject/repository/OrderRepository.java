package com.glo.TransportLogisticDomainCapstoneProject.repository;

import com.glo.TransportLogisticDomainCapstoneProject.domain.Customer;
import com.glo.TransportLogisticDomainCapstoneProject.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
