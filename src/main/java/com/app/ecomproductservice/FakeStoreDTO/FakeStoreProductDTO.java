package com.app.ecomproductservice.FakeStoreDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreProductDTO {
    long id;
    String title;
    double price;
    String category;
    String description;
}
