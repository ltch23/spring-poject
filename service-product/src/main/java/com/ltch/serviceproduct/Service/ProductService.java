package com.ltch.serviceproduct.Service;

import com.ltch.serviceproduct.Entity.Category;
import com.ltch.serviceproduct.Entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProduct();
    Product getProduct(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product updateStock(Long id, Double quantity);
    Product deleteProduct(Long id);
    List<Product> findByCategory(Category category);
}
