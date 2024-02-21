package com.example.ecommercebackend.api.controller.user;

import com.example.ecommercebackend.model.Address;
import com.example.ecommercebackend.model.User;
import com.example.ecommercebackend.repo.AddressRepository;
import com.example.ecommercebackend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    AddressService addressService;

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/{userId}/address")
    public ResponseEntity<List<Address>> getAddress(@AuthenticationPrincipal User user, @PathVariable Long userId) {
        if(!userHasPermission(user,userId))
        {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        List<Address> address = addressService.getAddress(userId);
        return ResponseEntity.ok(addressRepository.findByUser_Id(userId));
    }

    private boolean userHasPermission(User user, Long id)
    {
        return user.getId()==id;
    }

    public ResponseEntity<Address> updateAddress(@AuthenticationPrincipal User user, @PathVariable Long userId, @RequestBody Address address)
    {
        if(!userHasPermission(user,userId))
        {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        address.setId(null);
        User refUser =new User();
        refUser.setId(userId);
        address.setUser(refUser);
        return ResponseEntity.ok(addressRepository.save(address));

    }

}