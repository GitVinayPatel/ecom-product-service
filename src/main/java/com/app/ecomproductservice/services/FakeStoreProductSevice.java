package com.app.ecomproductservice.services;

import com.app.ecomproductservice.FakeStoreDTO.FakeStoreProductDTO;
import com.app.ecomproductservice.modles.Category;
import com.app.ecomproductservice.modles.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FakeStoreProductSevice implements ProductService {

    RestTemplate restTemplate;

    public FakeStoreProductSevice(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProducts(Long id) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);
        return productMapper(fakeStoreProductDTO);
    }

    public Product productMapper( FakeStoreProductDTO fakeStoreProductDTO)
    {
        Product product = new Product();

        product.setId(fakeStoreProductDTO.getId());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setTitle(fakeStoreProductDTO.getTitle());

        Category category = new Category();
        category.setDescription(fakeStoreProductDTO.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTOs = restTemplate.getForObject("https://fakestoreapi.com/products/",
                FakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO  : fakeStoreProductDTOs ){
            if(fakeStoreProductDTO != null)
            {
                products.add(productMapper(fakeStoreProductDTO));
            }

        }
         return products;

    }
}
