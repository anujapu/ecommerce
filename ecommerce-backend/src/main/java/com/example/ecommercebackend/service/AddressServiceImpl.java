package com.example.ecommercebackend.service;

import com.example.ecommercebackend.model.Address;
import com.example.ecommercebackend.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AddressServiceImpl implements  AddressService {
    @Autowired
    AddressRepository addressRepository;

    public List<Address> getAddress(@PathVariable Long userId)
    {
        return addressRepository.findByUser_Id(userId);

    }

}
