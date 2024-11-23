package com.mohamed.ecommerce.order;

import com.mohamed.ecommerce.customer.CustomerClient;
import com.mohamed.ecommerce.exception.BusinessException;
import com.mohamed.ecommerce.product.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    public Integer createOrder(OrderRequest request) {
        var customer =this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(()->new BusinessException("Cannot create order :: No Customer exists" +
                        "with the provided ID ::"+ request.customerId()));

        //purchase the product

        //persist order

        //persist order lines

        //start payment

        //send the order confirmation
        return null;
    }
}
