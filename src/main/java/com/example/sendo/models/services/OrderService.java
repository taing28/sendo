package com.example.sendo.models.services;

import com.example.sendo.models.repo.OrderRepo;
import com.example.sendo.models.services.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepo _orderRepo;
}
