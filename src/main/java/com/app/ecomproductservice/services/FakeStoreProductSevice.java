package com.app.ecomproductservice.services;

import com.app.ecomproductservice.DTOs.FakeStoreProductDTO;
import com.app.ecomproductservice.exception.ProductNotFoundException;
import com.app.ecomproductservice.modles.Category;
import com.app.ecomproductservice.modles.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductSevice implements ProductService {

    RestTemplate restTemplate;

    public FakeStoreProductSevice(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProducts(Long id) throws ProductNotFoundException {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);

        if(fakeStoreProductDTO ==null){
            throw new ProductNotFoundException("Product with id"+ id +"dosen't exist");
        }
        return productMapper(fakeStoreProductDTO);
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

    @Override
    public Product removeProduct(Long id) {

        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);

        return productMapper(fakeStoreProductDTO);
    }

    @Override
    public Product  updateProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);
        return  productMapper(response);
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


}
