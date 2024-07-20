package com.app.ecomproductservice.modles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    long id;
    String title;
    double price;
    Category category;
}
