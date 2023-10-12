package com.plgrim.dddshop.product.interfaces.rest;

import com.plgrim.dddshop.product.application.internal.commandservices.ProductCommandService;
import com.plgrim.dddshop.product.application.internal.queryservices.ProductQueryService;
import com.plgrim.dddshop.product.domain.model.aggregates.CreateProductId;
import com.plgrim.dddshop.product.domain.model.aggregates.Product;
import com.plgrim.dddshop.product.interfaces.rest.dto.CreateProductResource;
import com.plgrim.dddshop.product.interfaces.rest.transform.CreateProductCommandDTOAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
public class ProductRestController {

    private ProductCommandService productCommandService;
    private ProductQueryService productQueryService;

    public ProductRestController(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }

    @PostMapping("/product")
    public ResponseEntity<CreateProductId> createProduct(@Valid @RequestBody CreateProductResource createProductResource) {
        CreateProductId createProductId = productCommandService.createProduct(
        CreateProductCommandDTOAssembler.toCommandFromDTO(createProductResource));
        final URI uri =
            MvcUriComponentsBuilder.fromController(getClass())
            .path("/{id}")
            .buildAndExpand(createProductId.getCreateProductId())
            .toUri();
        return ResponseEntity.created(uri).body(createProductId);
    }

    @GetMapping("/product")
    public Product findByCreateProductId(@RequestParam String createProductId) throws Exception {
        return productQueryService.findByCreateProductId(createProductId);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productQueryService.findAll();
    }

    @PutMapping("/product")
    public String updateProduct() {
        return "products";
    }

    @DeleteMapping("/product/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        return "products";
    }
}