package com.glo.TransportLogisticDomainCapstoneProject.service;

import com.glo.TransportLogisticDomainCapstoneProject.domain.Customer;
import com.glo.TransportLogisticDomainCapstoneProject.domain.Order;

import java.util.List;

public interface OrderService {
    public void addOrder(Order order);
    public void updateOrderStatus(Order order);
    public void deleteOrder(int order_id);
    public List<Order> getAllCustomerOrders(int customer_id);
    public List<Order> getAllOrders();
    public Order getOrderById(int order_id);
}
