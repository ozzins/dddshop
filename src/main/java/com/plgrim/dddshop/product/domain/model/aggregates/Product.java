package com.plgrim.dddshop.product.domain.model.aggregates;

import com.plgrim.dddshop.product.domain.model.commands.CreateProductCommand;
import com.plgrim.dddshop.product.domain.model.valueobjects.ProductBaseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class Product extends AbstractAggregateRoot<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CreateProductId createProductId;

    @Embedded
    private ProductBaseInfo productBaseInfo;

    public Product(CreateProductCommand createProductCommand) {
    this.createProductId = new CreateProductId(createProductCommand.getProductId());
    this.productBaseInfo = new ProductBaseInfo(createProductCommand.getProductName());
    }
}