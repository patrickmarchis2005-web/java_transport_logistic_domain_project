package com.glo.TransportLogisticDomainCapstoneProject.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String product_name;
    private double product_price;
    private int product_quantity_inStock;

    public Product(int product_id, String product_name, int product_price, int product_quantity_inStock) {
        super();
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity_inStock = product_quantity_inStock;
    }

    public Product() {
        super();
    }

    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public double getProduct_price() {
        return product_price;
    }
    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }
    public int getProduct_quantity_inStock() {
        return product_quantity_inStock;
    }
    public void setProduct_quantity_inStock(int product_quantity_inStock) {
        this.product_quantity_inStock = product_quantity_inStock;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Product{");
        sb.append("id='").append(product_id);
        sb.append(", name='").append(product_name);
        sb.append(", price=").append(product_price);
        sb.append(", quantityInStock=").append(product_quantity_inStock);
        sb.append("}");
        return sb.toString();
    }
}
