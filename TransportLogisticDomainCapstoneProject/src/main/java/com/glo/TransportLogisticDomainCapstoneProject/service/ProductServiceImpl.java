package com.glo.TransportLogisticDomainCapstoneProject.service;

import com.glo.TransportLogisticDomainCapstoneProject.domain.Product;
import com.glo.TransportLogisticDomainCapstoneProject.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        Product foundProduct = productRepository.findById(product.getProduct_id()).orElse(null);
        if (foundProduct != null) {
            LOGGER.error("Product with id {} already exists", product.getProduct_id());
            return;
        }
        productRepository.save(product);
        LOGGER.info("Product with id {} has been added", product.getProduct_id());
    }

    public void updateProduct(Product product) {
        Product foundProduct = productRepository.findById(product.getProduct_id()).orElse(null);
        if (foundProduct != null) {
            LOGGER.error("Product with id {} was not found", product.getProduct_id());
            return;
        }
        productRepository.save(product);
        LOGGER.info("Product with id {} has been updated", product.getProduct_id());
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            LOGGER.error("Product with id {} was not found", id);
            return null;
        }
        return product.get();
    }

    public void deleteProduct(int id) {
        Product foundProduct = productRepository.findById(id).orElse(null);
        if (foundProduct == null) {
            LOGGER.error("Product with id {} was not found", id);
            return;
        }
        productRepository.delete(foundProduct);
        LOGGER.info("Product with id {} has been deleted", id);
    }
}
