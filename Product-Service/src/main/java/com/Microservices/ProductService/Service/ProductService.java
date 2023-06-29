package com.Microservices.ProductService.Service;

import com.Microservices.ProductService.Dto.ProductRequest;
import com.Microservices.ProductService.Dto.ProductResponse;
import com.Microservices.ProductService.Model.Product;
import com.Microservices.ProductService.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {

    private final ProductRepository productrepo;
    public  void createProduct(ProductRequest productRequest){
        Product product=Product.builder()
                        .id(productRequest.getId())
                                .name(productRequest.getName())
                                        .Description(productRequest.getDescription())
                                                .price(productRequest.getPrice()).build();

                productrepo.save(product);
                log.info("Product {} is saved",product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product>products=productrepo.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }
    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .Description(product.getDescription())
                .price(product.getPrice()).build();
    }
}
