package com.packt.webstore.service;

/**
 * Created by Cyprian on 2017-03-03.
 */
public interface OrderService {

    void processOrder(String productId, int count);
}
