package com.example.ecommercebackend.repo;


import com.example.ecommercebackend.model.Requisition;
import com.example.ecommercebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequisitionRepository extends JpaRepository<Requisition,Long> {

List<Requisition> findByUser(User user);
}
