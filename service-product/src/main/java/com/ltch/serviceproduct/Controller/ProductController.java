package com.ltch.serviceproduct.Controller;

import com.ltch.serviceproduct.Entity.Product;
import com.ltch.serviceproduct.Exception.ResourceNotFoundException;
import com.ltch.serviceproduct.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    final private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProduct() {
        List<Product> products = productService.listAllProduct();
        if (products==null || products.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Product> getProduct(@PathVariable String id){
        Product product = productService.getProduct(id);
        if (product == null){
            throw new ResourceNotFoundException(String.format("No existe un Producto con ese id: %s",id));
        }
        return ResponseEntity.ok(product);
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
        if (bindingResult.hasErrors())
            throw new ResourceNotFoundException(bindingResult.toString());
        Product productDb = productService.updateProduct(product);
        if (productDb==null)
            throw new ResourceNotFoundException(String.format("No existe un Producto con ese id: %s",product.get_id()));
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

