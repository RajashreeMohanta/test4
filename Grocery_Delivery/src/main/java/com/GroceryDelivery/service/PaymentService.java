package com.GroceryDelivery.service;

import java.util.List;

import com.GroceryDelivery.entity.Payment;
import com.GroceryDelivery.exception.PaymentNotFoundException;

public interface PaymentService {

	public Payment addPayment(Payment payment);
	public Payment updatePayment(Payment payment)throws PaymentNotFoundException;
	public boolean deletePaymentById(Integer paymentId);
	public List<Payment> getAllPaymentDetails();
	Payment removePayment(long id) throws PaymentNotFoundException;
	Payment getPaymentById(Integer paymentId) throws PaymentNotFoundException;
}
