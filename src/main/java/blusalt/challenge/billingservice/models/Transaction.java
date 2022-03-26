package blusalt.challenge.billingservice.models;

import blusalt.challenge.billingservice.enums.PaymentChannel;
import blusalt.challenge.billingservice.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(indexes = {
        @Index( columnList = "amount"),
        @Index( columnList = "currency"),
        @Index( columnList = "channel"),
        @Index( columnList = "clientReference"),
        @Index( columnList = "reference"),
        @Index( columnList = "customerId"),
}
)
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( columnDefinition="decimal (12, 2) NOT NULL default 0.0")
    private BigDecimal amount;

    @Column( nullable = false)
    private String currency;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentChannel channel;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status = PaymentStatus.PENDING;

    @Column(nullable = false, unique = true)
    private String clientReference;

    @Column(nullable = false, unique = true)
    private String reference;

    @Column(nullable = false)
    private String customerId;
}
