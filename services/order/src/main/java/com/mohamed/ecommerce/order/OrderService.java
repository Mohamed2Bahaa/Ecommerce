package com.mohamed.ecommerce.order;

import com.mohamed.ecommerce.customer.CustomerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    public Integer createOrder(OrderRequest request) {
        //check custoemr

        //purchase the product

        //persist order

        //persist order lines

        //start payment

        //send the order confirmation
        return null;
    }
}
