package com.ltch.serviceproduct.Controller;

import com.ltch.serviceproduct.Entity.Category;
import com.ltch.serviceproduct.Entity.Product;
import com.ltch.serviceproduct.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProduct(@RequestParam(name = "categoryId",required = false) Long categoryId) {
        List<Product> products = new ArrayList<>();
        if (categoryId == null) {
            products = productService.listAllProduct();
            if (products.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(products);
    }
    @PostMapping
    ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
        Product productDb = productService.createProduct(product);
        if (productDb==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productDb);
    }
    @PutMapping
    ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product, BindingResult bindingResult){
//        if (bindingResult.hasErrors())
//            return
        Product productDb = productService.updateProduct(product);
        if (productDb==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productDb);
    }

    @DeleteMapping
    ResponseEntity<Product> deleteProduct(@RequestParam String id){
        Product productDb = productService.deleteProduct(id);
        if (productDb==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productDb);
    }


}

