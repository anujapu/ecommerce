package com.example.ecommercebackend.service;

import com.example.ecommercebackend.model.Requisition;
import com.example.ecommercebackend.model.User;

import java.util.List;

public interface RequsitionService {
    public List<Requisition> getOrderForUser(User user);
}
