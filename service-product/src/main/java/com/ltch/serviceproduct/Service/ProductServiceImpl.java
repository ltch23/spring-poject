package com.ltch.serviceproduct.Service;

import com.ltch.serviceproduct.Entity.Category;
import com.ltch.serviceproduct.Entity.Product;
import com.ltch.serviceproduct.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ProductServiceImpl implements  ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus(1);
        product.setCreateAt(new Date());

        return  productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {

            Product productDb = getProduct(product.getId());
            if (productDb == null){
                return null;
            }
            productDb.setName(product.getName());
            productDb.setDescription(product.getDescription());
            productDb.setCategory(product.getCategory());
            productDb.setPrice(product.getPrice());

            return productRepository.save(productDb);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productDB = getProduct(id);
        if (productDB==null) return null;
        Double stock = productDB.getStock()+quantity;
        productDB.setStock(stock);

        return productRepository.save(productDB);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productDB = getProduct(id);
        if (productDB==null) return null;
        productDB.setStatus(0);
        return productRepository.save(productDB);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }
}
