package com.app.ecomproductservice.services;

import com.app.ecomproductservice.modles.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    public Product getSingleProducts(Long id);

    public List<Product> getAllProducts();
}
