package com.example.sendo.models.services;

import com.example.sendo.models.entities.Product;
import com.example.sendo.models.repo.ProductRepo;
import com.example.sendo.models.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product addNewProduct() throws Exception {
        return null;
    }

    @Override
    public Product updateProduct() throws Exception {
        return null;
    }
}
