package com.plgrim.dddshop.product.application.internal.queryservices;

import com.plgrim.dddshop.product.domain.model.aggregates.Product;
import com.plgrim.dddshop.product.domain.service.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductQueryService {

    private ProductRepository productRepository;
    
    public ProductQueryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public Product findByCreateProductId(String createProductId) throws Exception {
        Optional<Product> product = productRepository.findByCreateProductIdCreateProductId(createProductId);
        if(!product.isEmpty()) {
            return product.get();
        } else {
            throw new Exception("Product is not exist!!");
        }
    }
    
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
