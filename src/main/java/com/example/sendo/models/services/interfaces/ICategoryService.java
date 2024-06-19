package com.example.sendo.models.services.interfaces;

import com.example.sendo.models.dto.request.CategoryRequest;
import com.example.sendo.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category addNewCategory(CategoryRequest request) throws Exception;
    Category updateCategory(CategoryRequest request) throws Exception;
    void deleteCategory(Long id) throws Exception;
}
