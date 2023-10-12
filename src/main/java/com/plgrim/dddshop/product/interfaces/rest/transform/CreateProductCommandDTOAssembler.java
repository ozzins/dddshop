package com.plgrim.dddshop.product.interfaces.rest.transform;

import com.plgrim.dddshop.product.domain.model.commands.CreateProductCommand;
import com.plgrim.dddshop.product.interfaces.rest.dto.CreateProductResource;

public class CreateProductCommandDTOAssembler {

    public static CreateProductCommand toCommandFromDTO(CreateProductResource createProductResource) {
        return new CreateProductCommand(
            createProductResource.getProductName()
        );
    }
}
