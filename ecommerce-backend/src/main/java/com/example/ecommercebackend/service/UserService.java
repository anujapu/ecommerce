package com.example.ecommercebackend.service;

import com.example.ecommercebackend.api.model.LoginBody;
import com.example.ecommercebackend.api.model.RegistrationBody;
import com.example.ecommercebackend.model.User;

public interface UserService {

    public User registerUser(RegistrationBody registrationBody);
    public String loginUser(LoginBody loginBody);
}
