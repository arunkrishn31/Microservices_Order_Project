package com.Microservices.ProductService.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(value = "Product")
public class Product {
    @Id
    private String id;
    private  String name;
    private String Description;
    private BigDecimal price;
}
