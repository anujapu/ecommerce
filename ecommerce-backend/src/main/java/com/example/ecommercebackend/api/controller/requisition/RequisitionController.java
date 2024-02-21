package com.example.ecommercebackend.api.controller.requisition;

import com.example.ecommercebackend.model.Requisition;
import com.example.ecommercebackend.model.User;
import com.example.ecommercebackend.service.RequsitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class RequisitionController {

    @Autowired
    RequsitionService requisitionService;
@GetMapping
public List<Requisition> getOrders(@AuthenticationPrincipal User user)
{
  return  requisitionService.getOrderForUser(user);
}


}
