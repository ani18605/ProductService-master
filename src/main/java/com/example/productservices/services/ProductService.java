package com.example.productservices.services;

import com.example.productservices.dtos.FakeStoreDto;
import com.example.productservices.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {
    List<FakeStoreDto> getAllProducts(String limit, String sort) throws Exception;
    FakeStoreDto getSingleProduct(Long id);
    FakeStoreDto createProduct(FakeStoreDto product);
    void updateProduct(Long id, FakeStoreDto product);
    void deleteProduct(Long id);
    String[] getAllCategory();
    List<FakeStoreDto> getProductOfCategory(String productCategory);
}
