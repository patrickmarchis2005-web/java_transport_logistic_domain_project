package com.glo.TransportLogisticDomainCapstoneProject.controller;

import com.glo.TransportLogisticDomainCapstoneProject.domain.Customer;
import com.glo.TransportLogisticDomainCapstoneProject.domain.Order;
import com.glo.TransportLogisticDomainCapstoneProject.domain.Product;
import com.glo.TransportLogisticDomainCapstoneProject.service.CustomerService;
import com.glo.TransportLogisticDomainCapstoneProject.service.OrderService;
import com.glo.TransportLogisticDomainCapstoneProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.random.RandomGenerator;

@org.springframework.stereotype.Controller
public class Controller {
    private CustomerService customerService;
    private OrderService orderService;
    private ProductService productService;

    @Autowired
    public Controller(CustomerService customerService, OrderService orderService, ProductService productService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.productService = productService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("0. Exit");
            System.out.println("1. Customer mode");
            System.out.println("2. Admin mode");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    scanner.close();
                    return;
                case 1:
                    runCustomerMode(scanner);
                    break;
                case 2:
                    runAdminMode(scanner);
                    break;
            }
        }
    }

    public void runCustomerMode(Scanner scanner) {
        while (true) {
            System.out.println("0. Exit");
            System.out.println("1. View all products");
            System.out.println("2. Create order");
            System.out.println("3. See your orders");
            System.out.println("4. Delete unapproved order");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    return;

                case 1:
                    for (var product : productService.getAllProducts()) {
                        System.out.println(product.toString());
                    }
                    break;

                case 2:
                    System.out.println("Enter product ID:");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter required amount:");
                    int orderTotalAmount = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter customer ID:");
                    int customerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter product's stock:");
                    Long productStock = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter order's date (yyyy-mm-dd):");
                    String orderDate = scanner.nextLine();
                    String orderStatus = "UNAPPROVED";

                    Order order = new Order();
                    Product product = productService.getProductById(productId);
                    if (product == null) {
                        break;
                    }
                    order.setProduct(product);

                    order.setOrder_totalAmount(orderTotalAmount);
                    Customer customer = customerService.getCustomerById(customerId);
                    if (customer == null) {
                        break;
                    }
                    order.setCustomer(customer);

                    order.setOrder_product_quantity(productStock);
                    order.setOrder_date(orderDate);
                    order.setOrder_status(orderStatus);
                    orderService.addOrder(order);
                    break;

                case 3:
                    System.out.println("Enter your ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    for (var o : orderService.getAllCustomerOrders(id)) {
                        System.out.println(o.toString());
                    }
                    break;

                case 4:
                    System.out.println("Enter order's ID:");
                    int oId = scanner.nextInt();
                    scanner.nextLine();
                    orderService.deleteOrder(oId);
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public void runAdminMode(Scanner scanner) {
        while (true) {
            System.out.println("0. Exit");
            System.out.println("1. Add products");
            System.out.println("2. Update product quantity");
            System.out.println("3. Update product status");
            System.out.println("4. See all orders");
            System.out.println("5. Add customer");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    return;

                case 1:
                    System.out.println("Enter product name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter product price:");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter product stock:");
                    int quantityInStock = scanner.nextInt();
                    scanner.nextLine();

                    Product product = new Product();
                    product.setProduct_name(name);
                    product.setProduct_price(price);
                    product.setProduct_quantity_inStock(quantityInStock);
                    productService.addProduct(product);
                    break;

                case 2:
                    System.out.println("Enter product ID:");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter product's new quantity:");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    Product foundProduct = productService.getProductById(productId);
                    if (foundProduct != null) {
                        foundProduct.setProduct_quantity_inStock(quantity);
                    }
                    productService.updateProduct(foundProduct);
                    break;

                case 3:
                    System.out.println("Enter order's ID:");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter order's new status (APPROVED/ REJECTED):");
                    String orderStatus = scanner.nextLine();

                    Order foundOrder = orderService.getOrderById(orderId);
                    if (foundOrder != null) {
                        foundOrder.setOrder_status(orderStatus);
                    }
                    orderService.updateOrderStatus(foundOrder);
                    break;

                case 4:
                    for (var o : orderService.getAllOrders()) {
                        System.out.println(o.toString());
                    }

                case 5:
                    System.out.println("Enter customer name:");
                    String cust_name = scanner.nextLine();
                    System.out.println("Enter customer contact:");
                    Long cust_contact = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter customer address:");
                    String cust_address = scanner.nextLine();

                    Customer customer = new Customer();
                    customer.setCust_name(cust_name);
                    customer.setCust_contact(cust_contact);
                    customer.setCust_add(cust_address);
                    customerService.addCustomer(customer);

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
