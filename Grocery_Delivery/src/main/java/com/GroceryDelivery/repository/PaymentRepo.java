package com.GroceryDelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GroceryDelivery.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment,Integer>{

}
