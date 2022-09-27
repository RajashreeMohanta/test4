package com.GroceryDelivery;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.GroceryDelivery.entity.Payment;
import com.GroceryDelivery.exception.PaymentNotFoundException;
import com.GroceryDelivery.service.PaymentService;

@SpringBootTest
class GroceryDeliveryApplicationTests {

	@Autowired
	private PaymentService paymentService;
	
	@Test
	void addPaymentTest() throws PaymentNotFoundException {
		Payment payment = new Payment(46,"visa", "2354657657","Sbi","2022-07-04","done");
		Payment testPayment = this.paymentService.addPayment(payment);
		assertNotNull(testPayment);
	}

	private void assertNotNull(Payment testPayment) {
		// TODO Auto-generated method stub
		
	}
		@Test
		void updatePaymentTest() {
			Payment payment = new Payment(46, "5765756898", null, "2023-08-09", null,null);
			
			assertThrows(PaymentNotFoundException.class, () -> this.paymentService.updatePayment(payment));
		
	
	}

}
