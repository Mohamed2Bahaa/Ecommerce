package com.mohamed.ecommerce.orderline;

import com.mohamed.ecommerce.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderLinemapper {
    public OrderLine toOrderLine(OrderLineRequest request) {

        return OrderLine.builder().
                id(request.id()).
                quantity(request.quantity())
                        .order(
                                Order.builder().id(request.id())
                                        .build()
                        ).productId(request.productId()).
                build();
    }
}
