package com.Microservices.ProductService.Repository;

import com.Microservices.ProductService.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
