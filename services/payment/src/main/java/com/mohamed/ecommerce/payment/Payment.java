package com.mohamed.ecommerce.payment;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal  amount;
    private PaymentMethod paymentMethod;

}
