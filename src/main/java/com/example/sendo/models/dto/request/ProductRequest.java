package com.example.sendo.models.dto.request;

import com.example.sendo.models.entities.Image;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductRequest {
    private Long id;
    private String name;
    private String color;
    private String size;
    private Integer stock;
    private Double price;
    private String description;
    private Long categoryId;
    private List<Image> imageList;
}
