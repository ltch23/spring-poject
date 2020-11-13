package com.ltch.serviceproduct.Service;

import com.ltch.serviceproduct.Entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProduct();
    Product getProduct(String id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product updateStock(String id, Double quantity);
    Product deleteProduct(String id);
}
