package com.packt.webstore.service;

import com.packt.webstore.domain.repository.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Cyprian on 2017-03-04.
 */
public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(String productId);
    List<Product> getProductsByCategory(String category);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    void addProduct(Product product);

}
