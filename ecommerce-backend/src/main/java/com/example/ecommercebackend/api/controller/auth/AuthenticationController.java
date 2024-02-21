package com.example.ecommercebackend.api.controller.auth;

import com.example.ecommercebackend.api.model.LoginBody;
import com.example.ecommercebackend.api.model.LoginResponse;
import com.example.ecommercebackend.api.model.RegistrationBody;
import com.example.ecommercebackend.exception.UserAlreadyExistException;
import com.example.ecommercebackend.model.User;
import com.example.ecommercebackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody RegistrationBody registrationBody) {
        try {
            User u = userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

        @PostMapping("/login")
        public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody) {
        String jwt = userService.loginUser(loginBody);
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            return ResponseEntity.ok(response);
        }
    }
    @GetMapping("/me")
    public User getLoggedInUseProfile(@AuthenticationPrincipal User user)
    {
        return user;
    }


}
