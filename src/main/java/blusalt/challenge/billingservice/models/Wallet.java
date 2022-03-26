package blusalt.challenge.billingservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(indexes = @Index(columnList = "number, customer_id"))
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String number;

    @Column( columnDefinition="decimal (12, 2) NOT NULL default 0.0")
    private BigDecimal balance;

    @Column( nullable = false)
    private String currency;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = true)
    @Column( nullable = false)
    private long customer_id;

    @Column( columnDefinition="decimal (12, 2) NOT NULL default 0.0")
    private double lien;

    @Column( columnDefinition="boolean NOT NULL default true")
    private boolean is_active = true;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column( nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
