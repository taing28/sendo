package com.example.sendo.models.services;

import com.example.sendo.models.repo.ProductRepo;
import com.example.sendo.models.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepo _productRepo;
}
