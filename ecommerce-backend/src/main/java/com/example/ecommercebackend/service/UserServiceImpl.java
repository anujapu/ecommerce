package com.example.ecommercebackend.service;

import com.example.ecommercebackend.api.model.LoginBody;
import com.example.ecommercebackend.api.model.RegistrationBody;
import com.example.ecommercebackend.exception.UserAlreadyExistException;
import com.example.ecommercebackend.model.User;
import com.example.ecommercebackend.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

        @Autowired
        UserRepository userRepository;

        @Autowired
        EncryptionService encryptionService;

        @Autowired
        JWTService jwtService;

    @Override
    public User registerUser(RegistrationBody registrationBody) throws UserAlreadyExistException {

        if(userRepository.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()||
        userRepository.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent())
        {
            throw new UserAlreadyExistException();
        }
        User user=new User();
        user.setUsername(registrationBody.getUsername());
        user.setPassword(encryptionService.encrptPassword(registrationBody.getPassword()));
        user.setEmail(registrationBody.getEmail());
        user.setFirstname(registrationBody.getFirstname());
        user.setLastname(registrationBody.getLastname());
        return userRepository.save(user);
    }

    @Override
    public String loginUser(LoginBody loginBody) {
        Optional<User> opUser = userRepository.findByUsernameIgnoreCase(loginBody.getUsername());
        if (opUser.isPresent()) {
            User user = opUser.get();
            if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {
                return jwtService.GenerateToken(user.getUsername());
            }
        }
        return null;
    }


}
