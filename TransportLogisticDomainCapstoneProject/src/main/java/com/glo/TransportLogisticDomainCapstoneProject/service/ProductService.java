package com.glo.TransportLogisticDomainCapstoneProject.service;

import com.glo.TransportLogisticDomainCapstoneProject.domain.Product;

import java.util.List;

public interface ProductService {
    public void addProduct(Product product);
    public void updateProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(int product_id);
    public void deleteProduct(int product_id);
}
