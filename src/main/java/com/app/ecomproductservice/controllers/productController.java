package com.app.ecomproductservice.controllers;

import com.app.ecomproductservice.modles.Product;
import com.app.ecomproductservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class productController {

    ProductService productService;

    public productController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(productService.getSingleProducts(id), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id)
    {
        return productService.removeProduct(id);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody  Product product){
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replcaeProduct(@PathVariable("id") Long id, @RequestBody  Product product){
        return new Product();
    }




}
