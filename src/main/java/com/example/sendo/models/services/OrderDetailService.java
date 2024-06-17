package com.example.sendo.models.services;

import com.example.sendo.models.repo.OrderDetailRepo;
import com.example.sendo.models.services.interfaces.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private OrderDetailRepo _orderDetailRepo;
}
