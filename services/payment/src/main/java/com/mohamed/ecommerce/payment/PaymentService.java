package com.mohamed.ecommerce.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    public Integer createPayment(PaymentRequest request) {
        var payment= repository.save(mapper.toPayment(request));
   return null;
    }
}
