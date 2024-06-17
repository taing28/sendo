package com.example.sendo.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(insertable = false, updatable = false)
    private Long productId;
    @Column(insertable = false, updatable = false)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "productId", foreignKey = @ForeignKey(name = "fk_orderdetail_product"))
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orderId", foreignKey = @ForeignKey(name = "fk_orderdetail_order"))
    @JsonIgnore
    private Order order;
}
