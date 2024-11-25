package com.mohamed.ecommerce.order;

import com.mohamed.ecommerce.customer.CustomerClient;
import com.mohamed.ecommerce.exception.BusinessException;
import com.mohamed.ecommerce.kafka.OrderConfirmation;
import com.mohamed.ecommerce.kafka.OrderProducer;
import com.mohamed.ecommerce.orderline.OrderLineRequest;
import com.mohamed.ecommerce.orderline.OrderLineService;
import com.mohamed.ecommerce.product.ProductClient;
import com.mohamed.ecommerce.product.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper mapper;
    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    public Integer createOrder(OrderRequest request) {
        var customer =this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(()->new BusinessException("Cannot create order :: No Customer exists" +
                        "with the provided ID ::"+ request.customerId()));

        //purchase the product
     var purchasedProducts = this.productClient.purchaseProducts(request.products());

        //persist order
        var order = this.repository.save(mapper.toOrder(request));

        //persist order lines
        for (PurchaseRequest purchaseRequest: request.products())
        {
            orderLineService.saveOrderLine(
                    new OrderLineRequest
                    (
                    null,
                     order.getId(),
                     purchaseRequest.productId(),
                     purchaseRequest.quantity()
                    )
            );

        }
        //todo start payment

        //send the order confirmation

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.PaymentMethod(),
                        customer,
                        purchasedProducts
                )
        );
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return repository.findAll().
                stream().map(mapper::fromOrder)
                .collect(Collectors.toList());
    }
}
