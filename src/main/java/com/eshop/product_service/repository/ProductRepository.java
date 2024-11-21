package com.eshop.product_service.repository;

import com.eshop.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    public Product findProductByCode(String code);
}
