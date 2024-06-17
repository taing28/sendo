package com.example.sendo.models.services;

import com.example.sendo.models.repo.BillRepo;
import com.example.sendo.models.services.interfaces.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService implements IBillService {
    @Autowired
    private BillRepo _billRepo;
}
