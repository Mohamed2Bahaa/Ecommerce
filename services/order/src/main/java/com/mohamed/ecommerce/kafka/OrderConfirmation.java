package com.mohamed.ecommerce.kafka;

import com.mohamed.ecommerce.customer.CustomerResponse;
import com.mohamed.ecommerce.order.PaymentMethod;
import com.mohamed.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(

        String orderRefrence,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,

        List<PurchaseResponse> products
) {
}
