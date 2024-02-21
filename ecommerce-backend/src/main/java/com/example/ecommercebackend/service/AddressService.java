package com.example.ecommercebackend.service;

import com.example.ecommercebackend.model.Address;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AddressService {

    public List<Address> getAddress(@PathVariable Long userId);
}
