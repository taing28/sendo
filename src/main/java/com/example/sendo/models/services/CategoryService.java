package com.example.sendo.models.services;

import com.example.sendo.models.dto.request.CategoryRequest;
import com.example.sendo.models.entities.Category;
import com.example.sendo.models.repo.CategoryRepo;
import com.example.sendo.models.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(rollbackFor = Exception.class)
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepo _categoryRepo;

    @Override
    public List<Category> findAll() {
        return _categoryRepo.findAll();
    }

    @Override
    public Category addNewCategory(CategoryRequest request) throws Exception {
        Category category = CategoryRequest.toEntity(request);
        if(_categoryRepo.existsByNameEquals(category.getName())){
            throw new Exception("Category name is existed");
        }
        return _categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(CategoryRequest request) throws Exception {
        Category reCategory = CategoryRequest.toEntity(request);
        Category namedCategory = _categoryRepo.findByNameEquals(reCategory.getName());
        if(namedCategory != null && namedCategory.getId() != reCategory.getId()){
            throw new Exception("Category name is existed");
        }
        return _categoryRepo.save(reCategory);
    }

    @Override
    public void deleteCategory(Long id) throws Exception {
        _categoryRepo.deleteById(id);
    }
}
