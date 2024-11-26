package com.mohamed.ecommerce.notification;

import com.mohamed.ecommerce.payment.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,

        PaymentMethod paymentMethod,

        String customerFirstname,

        String customerlastname,
        String customerEmail
) {
}
