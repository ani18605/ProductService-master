package com.example.productservices.services;

import com.example.productservices.dtos.FakeStoreDto;
import com.example.productservices.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.List;

@Service
public class FakestoreProductService implements ProductService{

    RestTemplate restTemplate = new RestTemplate();
    private final String url = "https://fakestoreapi.com/products";
    @Override
    public List<FakeStoreDto> getAllProducts(String limit, String sort) throws Exception {
        String urlCopy = new String(url);
        System.out.println(limit);

        urlCopy += "?sort="+sort;
        if(!limit.equals("-1"))
            urlCopy += "&limit="+limit;

        FakeStoreDto[] response = restTemplate.getForObject(
                urlCopy,
                FakeStoreDto[].class
        );
        if(response != null){
            return Arrays.asList(response);
        }
        else throw new Exception("No products received");
    }

    @Override
    public FakeStoreDto getSingleProduct(Long id) {
        FakeStoreDto response = restTemplate.getForObject(
                url+"/"+id,
                FakeStoreDto.class
        );
        return response;
    }

    @Override
    public FakeStoreDto createProduct(FakeStoreDto product) {
        FakeStoreDto newProduct = restTemplate.postForObject(
                url,
                product,
                FakeStoreDto.class
        );

        return newProduct;
    }

    @Override
    public void updateProduct(Long id, FakeStoreDto product) {
        restTemplate.put(
                url+"/"+id,
                product
        );
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete(
                url+"/"+id
        );
    }

    @Override
    public String[] getAllCategory(){
        String[] response = restTemplate.getForObject(
                url+"/categories",
                String[].class
        );
        return response;
    }

    @Override
    public List<FakeStoreDto> getProductOfCategory(String productCategory) {
        FakeStoreDto[] response = restTemplate.getForObject(
                url+"/category/"+productCategory,
                FakeStoreDto[].class
        );
        return Arrays.asList(response);
    }
}
