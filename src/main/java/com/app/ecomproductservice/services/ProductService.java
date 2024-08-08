package com.app.ecomproductservice.services;

import com.app.ecomproductservice.modles.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    public Product getSingleProducts(Long id);

    public List<Product> getAllProducts();

    public Product removeProduct(Long id);

    public Product updateProduct(Long id, Product product);
}
