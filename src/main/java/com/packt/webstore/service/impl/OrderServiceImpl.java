package com.packt.webstore.service.impl;

import com.packt.webstore.domain.repository.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Cyprian on 2017-03-03.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    public void processOrder(String productId, int count) {
        Product productById = productRepository.getProductById(productId);
        if(productById.getUnitsInStock()<count){
            throw new IllegalArgumentException("Za malo towaru mamy tylko: " + productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock()-count);
    }
}
