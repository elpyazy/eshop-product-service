package com.eshop.product_service.controller;

import com.eshop.product_service.dto.ProductDto;
import com.eshop.product_service.model.Product;
import com.eshop.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    ProductService productService;


    @Autowired
    public ProductController(final ProductService productService){
       this.productService = productService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "code", required = true) String code){
        Product product = productService.findProduct(code);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
      return ResponseEntity.ok(productService.saveProduct(productDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> fetchProducts(@RequestParam("q") String query){
        return ResponseEntity.ok(productService.findProducts(query));
    }
}
