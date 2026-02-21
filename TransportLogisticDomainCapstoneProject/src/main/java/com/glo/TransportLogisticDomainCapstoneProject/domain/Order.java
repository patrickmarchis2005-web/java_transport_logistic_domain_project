package com.glo.TransportLogisticDomainCapstoneProject.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private double order_totalAmount;
    private String order_date;
    private String order_status;
    private Long order_product_quantity;

    @OneToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    public Order(int order_id, int order_totalAmount, String orderDate, String order_status, int product_id, int cust_id, Long order_product_quantity) {
        super();
        this.order_id = order_id;
        this.order_totalAmount = order_totalAmount;
        this.order_date = orderDate;
        this.order_status = order_status;
        this.order_product_quantity = order_product_quantity;
    }

    public Order() {
        super();
    }

    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public double getOrder_totalAmount() {
        return order_totalAmount;
    }
    public void setOrder_totalAmount(double order_totalAmount) {
        this.order_totalAmount = order_totalAmount;
    }
    public String getOrder_date() {
        return order_date;
    }
    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
    public String getOrder_status() {
        return order_status;
    }
    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Long getOrder_product_quantity() {
        return order_product_quantity;
    }
    public void setOrder_product_quantity(Long order_product_quantity) {
        this.order_product_quantity = order_product_quantity;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Order {");
        sb.append("orderId='").append(order_id);
        sb.append(", orderTotalAmount=").append(order_totalAmount);
        sb.append(", orderDate=").append(order_date);
        sb.append(", orderStatus='").append(order_status);
        sb.append(", product='").append(product);
        sb.append(", customer='").append(customer);
        sb.append(", orderProductQuantity=").append(order_product_quantity);
        sb.append("}");
        return sb.toString();
    }
}
