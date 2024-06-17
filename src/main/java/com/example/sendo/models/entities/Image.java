package com.example.sendo.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(insertable = false, updatable = false)
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "productId", foreignKey = @ForeignKey(name = "fk_image_product"))
    @JsonIgnore
    private Product productImage;
}
