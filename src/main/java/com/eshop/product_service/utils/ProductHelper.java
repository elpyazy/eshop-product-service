package com.eshop.product_service.utils;

import com.eshop.product_service.dto.ProductDto;
import com.eshop.product_service.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductHelper {

    public Product buildNewProduct(ProductDto dto){
       return Product.builder()
               .code(dto.getCode())
               .name(dto.getName())
               .description(dto.getDescription())
               .price(dto.getPrice())
               .stock(dto.getStock())
               .build();
    }

    public ProductDto mapToProductDto(Product model){
        return ProductDto.builder()
                .code(model.getCode())
                .name(model.getName())
                .description(model.getDescription())
                .price(model.getPrice())
                .stock(model.getStock())
                .build();
    }
}
