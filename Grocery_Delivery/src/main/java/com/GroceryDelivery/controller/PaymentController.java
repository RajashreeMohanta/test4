package com.GroceryDelivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GroceryDelivery.entity.Payment;
import com.GroceryDelivery.exception.PaymentNotFoundException;
import com.GroceryDelivery.service.PaymentService;

@RestController
	@RequestMapping("v1")
	@CrossOrigin(value = "http://localhost:4200/")

	public class PaymentController {

			
		@Autowired
			private PaymentService paymentService;
		
		@PostMapping("payment")
		public Payment addPayment(@Valid @RequestBody Payment payment) {
			return this.paymentService.addPayment(payment);

	}
		@PutMapping("payment")
	  	public Payment updatePayment(@RequestBody Payment payment) throws PaymentNotFoundException {
	  		return this.paymentService.updatePayment(payment);
	  	}
		  @DeleteMapping("payment/{paymentId}")
	      public boolean deletePaymentById(@PathVariable("paymentId")Integer paymentId) {
		return this.paymentService.deletePaymentById(paymentId);
	}
		  @GetMapping("payment/{id}")
			public Payment getpaymentById(@PathVariable("id") Integer paymentId ) throws PaymentNotFoundException {
				return this.paymentService.getPaymentById(paymentId);
			}
		
		@GetMapping("payments")
		public List<Payment>getAllPaymentDetails (){
			return this.paymentService.getAllPaymentDetails();
		}

}
