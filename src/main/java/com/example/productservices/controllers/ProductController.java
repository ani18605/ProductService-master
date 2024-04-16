package com.example.productservices.controllers;

import com.example.productservices.dtos.FakeStoreDto;
import com.example.productservices.models.Product;
import com.example.productservices.services.FakestoreProductService;
import com.example.productservices.services.ProductService;
import jdk.jfr.Frequency;
import org.springframework.core.PriorityOrdered;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<FakeStoreDto> getAllProducts(@RequestParam HashMap<String, String> map) throws Exception {
        String limit = "-1";
        if(map.containsKey("limit")) {
            limit = map.get("limit");
        }
        String sort = "asc";
        if(map.containsKey("sort")) {
            sort = map.get("sort");
        }
        return productService.getAllProducts(limit, sort);
    }

    @GetMapping("/products/{id}")
    public FakeStoreDto getSingleProduct(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

    @PostMapping("/products")
    public FakeStoreDto createProduct(@RequestBody FakeStoreDto product) {
        return productService.createProduct(product);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody FakeStoreDto product){
        productService.updateProduct(id,product);


    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/products/category")
    public String[] getAllCategory(){
        return productService.getAllCategory();
    }

    @GetMapping("/products/category/{productCategory}")
    public List<FakeStoreDto> getProductOfCategory(@PathVariable("productCategory") String productCategory) {
        return productService.getProductOfCategory(productCategory);
    }
}













