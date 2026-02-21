package com.glo.TransportLogisticDomainCapstoneProject.service;

import com.glo.TransportLogisticDomainCapstoneProject.domain.Order;
import com.glo.TransportLogisticDomainCapstoneProject.domain.Product;
import com.glo.TransportLogisticDomainCapstoneProject.repository.OrderRepository;
import com.glo.TransportLogisticDomainCapstoneProject.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,  ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public void addOrder(Order order) {
        Optional<Product> foundProduct = productRepository.findById(order.getProduct().getProduct_id());
        if (foundProduct.isEmpty()) {
            LOGGER.error("Product not found");
            return;
        }
        if (foundProduct.get().getProduct_quantity_inStock() != order.getOrder_product_quantity()) {
            LOGGER.error("The products' quantities in stock do not match");
            return;
        }
        if (foundProduct.get().getProduct_quantity_inStock() < (int)order.getOrder_totalAmount()) {
            LOGGER.error("The product's quantity in stock is less than the order's amount requested");
            return;
            // product stock quantity is less than the order total required amount
        }
        orderRepository.save(order);
        // then, update the product's quantity in stock
        foundProduct.get().setProduct_quantity_inStock(foundProduct.get().getProduct_quantity_inStock() - (int)order.getOrder_totalAmount());
        productRepository.save(foundProduct.get());
        LOGGER.info("Order added successfully: " + order.toString());
    }

    public void updateOrderStatus(Order order) {
        Optional<Product> foundProduct = productRepository.findById(order.getProduct().getProduct_id());
        if (foundProduct.isEmpty()) {
            LOGGER.error("Product not found");
            return;
        }
        if (foundProduct.get().getProduct_quantity_inStock() < order.getOrder_totalAmount()) {
            LOGGER.error("The product's quantity in stock is less then the order's amount requested");
            return;
            // product stock quantity is less than the updated order total required amount
        }

        orderRepository.save(order);
        LOGGER.info("Order updated successfully: " + order.toString());
    }

    public void deleteOrder(int id) {
        Order foundOrder = orderRepository.findById(id).orElse(null);
        if (foundOrder == null) {
            LOGGER.error("Order not found");
            return;
        }
        orderRepository.delete(foundOrder);
        LOGGER.info("Order deleted successfully");
    }

    public List<Order> getAllCustomerOrders(int customerId) {
        return orderRepository.findAll().stream().filter(order -> order.getCustomer().getCust_id() == customerId).collect(Collectors.toList());
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }
}
