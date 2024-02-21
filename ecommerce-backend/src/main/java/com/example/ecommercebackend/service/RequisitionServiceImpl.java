package com.example.ecommercebackend.service;

import com.example.ecommercebackend.model.Requisition;
import com.example.ecommercebackend.model.User;
import com.example.ecommercebackend.repo.RequisitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisitionServiceImpl implements RequsitionService {

    @Autowired
    RequisitionRepository requisitionRepository;

    public List<Requisition> getOrderForUser(User user)
    {
       return requisitionRepository.findByUser(user);

    }
}

