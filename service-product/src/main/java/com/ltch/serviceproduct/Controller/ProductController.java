package com.ltch.serviceproduct.Controller;

import com.ltch.serviceproduct.Entity.Category;
import com.ltch.serviceproduct.Entity.Product;
import com.ltch.serviceproduct.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProduct(@RequestParam(name = "categoryId",required = true) Long categoryId) {
        List<Product> products = new ArrayList<>();
        if (categoryId == categoryId) {
            products = productService.listAllProduct();
            if (products.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        } else {
            products = productService.findByCategory(Category.builder().id(categoryId).build());
            if (products.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }
    return ResponseEntity.ok(products);
    }

}

