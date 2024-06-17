package com.example.sendo.models.services;

import com.example.sendo.models.repo.CategoryRepo;
import com.example.sendo.models.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
}
