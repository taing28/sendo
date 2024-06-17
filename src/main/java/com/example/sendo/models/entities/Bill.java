package com.example.sendo.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;
    private Double totalPrice;
    private String address;
    @Column(insertable = false, updatable = false)
    private Long customerId;

    public Bill(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "customerId", foreignKey = @ForeignKey(name = "fk_order_user"))
    @JsonIgnore
    private User userOrder;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bill")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<OrderDetail> orderDetailList;
}
