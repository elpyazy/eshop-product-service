package com.eshop.product_service.service;

import com.eshop.product_service.dto.ProductDto;
import com.eshop.product_service.model.Product;
import com.eshop.product_service.repository.ProductRepository;
import com.eshop.product_service.utils.ProductHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductHelper productHelper;

    public Product findProduct(final String code){
       return productRepository.findProductByCode(code);
    }

    public ProductDto saveProduct(ProductDto productDto) {
       Product product = productRepository.save(productHelper.buildNewProduct(productDto));
       log.info("Created Product: {}",product.getCode());
       return productHelper.mapToProductDto(product);
    }

    public List<ProductDto> findProducts(String query) {
        log.info("Querying products for {}",query);
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> productHelper.mapToProductDto(product)).collect(Collectors.toList());
    }
}
