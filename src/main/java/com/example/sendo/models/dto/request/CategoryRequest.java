package com.example.sendo.models.dto.request;

import com.example.sendo.models.entities.Category;

public class CategoryRequest {
    private Long id;
    private String name;

    public static Category toEntity(CategoryRequest request){
        Category category = new Category();
        if(request.id != 0){
            category.setId(request.id);
        }
        category.setName(request.name);
        return category;
    }
}
