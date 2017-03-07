package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Cyprian on 2017-03-03.
 */
public interface ProductRepository {

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Product getProductById(String productId);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    void addProduct( Product product);
}
