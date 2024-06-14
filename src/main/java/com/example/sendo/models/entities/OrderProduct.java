package com.example.sendo.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(insertable = false, updatable = false)
    private Long productId;
    @Column(insertable = false, updatable = false)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "productId", foreignKey = @ForeignKey(name = "fk_productOrder"))
    @JsonIgnore
    private Product productOrder;

    @ManyToOne
    @JoinColumn(name = "orderId", foreignKey = @ForeignKey(name = "fk_orderProduct"))
    @JsonIgnore
    private Order orderProduct;
}
