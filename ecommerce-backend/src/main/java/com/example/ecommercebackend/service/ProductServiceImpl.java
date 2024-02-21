package com.example.ecommercebackend.service;

import com.example.ecommercebackend.model.Product;
import com.example.ecommercebackend.repo.ProdcutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProdcutRepository prodcutRepository;
    public List<Product> getAllProducts()
    {
        return prodcutRepository.findAll();

    }
    }
