package com.example.sendo.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String color;
    private String size;
    private Integer stock;
    private Double price;
    private String description;
    @Column(insertable = false, updatable = false)
    private Long categoryId;

    public Product(Long id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<OrderDetail> orderDetailList;

    @ManyToOne
    @JoinColumn(name = "categoryId", foreignKey = @ForeignKey(name = "fk_product_category"))
    @JsonIgnore
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "productImage")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Image> imageList;
}
