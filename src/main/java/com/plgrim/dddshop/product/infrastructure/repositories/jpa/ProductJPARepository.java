package com.plgrim.dddshop.product.infrastructure.repositories.jpa;

import com.plgrim.dddshop.product.domain.model.aggregates.Product;
import com.plgrim.dddshop.product.domain.service.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductJPARepository extends ProductRepository, JpaRepository<Product, Long> {
    Product save(Product product);
    Optional<Product> findByCreateProductIdCreateProductId(String createProductId);
    List<Product> findAll();
}