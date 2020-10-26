package com.ltch.serviceproduct.Repository;

import com.ltch.serviceproduct.Entity.Category;
import com.ltch.serviceproduct.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategory(Category category);
}
