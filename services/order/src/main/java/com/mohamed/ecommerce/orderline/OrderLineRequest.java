package com.mohamed.ecommerce.orderline;

public record OrderLineRequest(Integer id,
                               Integer OrderId,
                               Integer productId,
                               double quantity
) {

}
