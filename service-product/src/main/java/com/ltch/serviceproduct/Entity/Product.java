package com.ltch.serviceproduct.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "c_products")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Product {
    @Id
    private ObjectId _id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private Integer status;
    private Date createAt;
    private List<Category> categories;
}
