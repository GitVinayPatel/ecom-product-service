package com.app.ecomproductservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    long id;
    String title;
    double price;
    String category;
    String description;
}
