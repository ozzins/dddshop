package com.plgrim.dddshop.product.domain.service;

import com.plgrim.dddshop.product.domain.model.aggregates.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findByCreateProductIdCreateProductId(String createProductId);
    List<Product> findAll();
}
