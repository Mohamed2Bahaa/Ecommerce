package com.mohamed.ecommerce.orderline;


import com.mohamed.ecommerce.order.Order;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class OrderLine {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "")
    private Order order;

    private Integer productId;
    private double quantity;
}
