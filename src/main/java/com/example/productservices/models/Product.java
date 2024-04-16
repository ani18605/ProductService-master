package com.example.productservices.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product {
    private Long id;
    private String title;
    private String description;
    private String category;
    private double price;
}
