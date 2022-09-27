package com.GroceryDelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GroceryDelivery.entity.Payment;
import com.GroceryDelivery.exception.PaymentNotFoundException;
import com.GroceryDelivery.repository.PaymentRepo;

/************************************************************************************
 *          @author          Rajashree Mohanta
 *          Description      It is a delivery app that provides the deliveries for adding new payment 
                                         and viewing all the payments  
  *         Version             1.0
  *         Created Date    02-Sept-2022
 ************************************************************************************/


@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;

	/************************************************************************************
	 * Method: Add Payment
	 *Description: To Add payment on the GroceryDeliveryApp
	 * @param PaymentIdID       - User's Payment ID

	 * @param pytm                          - Payment to be Added
	 * @returns Boolean                  - true, if Added otherwise throws PaymentNotFoundException
	 * @throws PaymentNotFoundException - It is raised due to insufficient data  or invalid payment Id or  
	                                                                     server side validation
	 *Created By                                -Rajashree Mohanta 
	 *Created Date                            - 02-Sept-2022                          
	 
	 ************************************************************************************/

	@Override
	public Payment addPayment(Payment payment) {
		return this.paymentRepo.save(payment);
		
	}

	/************************************************************************************
     * Method: RemovePayment
*Description: To Remove payment from the GroceryDeliveryApp
* @param PaymentIdID       - User's Payment ID

* @param pytm                          - Payment to be removed
* @returns Boolean                  - true, if removed otherwise throws PaymentNotFoundException
* @throws PaymentNotFoundException - It is raised due to insufficient data  or invalid payment Id or  
                                                    server side validation
*Created By                                -Rajashree Mohanta
*Created Date                            - 02-Sept-2022           

************************************************************************************/
	@Override
	public Payment removePayment(long id) throws PaymentNotFoundException{
		
	  return null;
	}


	/************************************************************************************
	  * Method: UpdatePayment
	 *Description: To Update payment on the GroceryDeliveryApp
	 * @param PaymentIdID       - User's Payment ID

	 * @param pytm                          - Payment to be updated
	 * @returns Boolean                  - true, if updated otherwise throws PaymentNotFoundException
	 * @throws PaymentNotFoundException - It is raised due to insufficient data  or invalid payment Id or  
	                                                                     server side validation
	 *Created By                                -Rajashree Mohanta 
	 *Created Date                            - 02-Sept-2022                      
	 
	 ************************************************************************************/
	
	@Override
	public Payment updatePayment(Payment payment) throws PaymentNotFoundException {
		
		
		Optional<Payment> paymentOpt=this.paymentRepo.findById(payment.getPaymentId());
		if(paymentOpt.isEmpty()) {
			throw new PaymentNotFoundException("Payment id not found");
		}
		Payment updatePayment=paymentOpt.get();
		updatePayment.setCardNumber(payment.getCardNumber());
		updatePayment.setCardName(payment.getCardName());
		updatePayment.setCardExpiry(payment.getCardExpiry());
		updatePayment.setBankName(payment.getBankName());
		updatePayment.setStatus(payment.getStatus());
		return this.paymentRepo.save(updatePayment);
		

	}


	/************************************************************************************
	* Method: DeletePayment
	 *Description: To Delete payment on the GroceryDeliveryApp
	 * @param PaymentIdID       - User's Payment ID

	 * @param pytm                          - Payment to be Deleted
	 * @returns Boolean                  - true, if Deleting otherwise throws PaymentNotFoundException
	 * @throws PaymentNotFoundException - It is raised due to insufficient data  or invalid payment Id or  
	                                                                     server side validation
	 *Created By                                -Rajashree Mohanta 
	 *Created Date                            - 02-Sept-2022         
	 ************************************************************************************/	

	@Override
	public boolean deletePaymentById(Integer paymentId) {
		this.paymentRepo.deleteById(paymentId);
		return true;
	}


	/************************************************************************************
	* Method: DisplayPayment/getPayment
	 *Description: To Displaying/getting Data 
	 * @param PaymentIdID       - User's Payment ID

	 * @param pytm                          - Payment to be Displaying/getting 
	 * @returns Boolean                  - true, if Displaying/getting otherwise throws PaymentNotFoundException
	 * @throws PaymentNotFoundException - It is raised due to insufficient data  or invalid payment Id or  
	                                                                     server side validation
	 *Created By                                -Rajashree Mohanta 
	 *Created Date                            - 02-Sept-2022         
	 ************************************************************************************/	
	@Override
	public Payment getPaymentById(Integer paymentId) throws PaymentNotFoundException {
		Optional<Payment> paymentOpt= this.paymentRepo.findById(paymentId);
		if(paymentOpt.isEmpty())
			throw new PaymentNotFoundException("Id Not Found");
		
		return paymentOpt.get();
	}


	@Override
	public List<Payment> getAllPaymentDetails() {
		return this.paymentRepo.findAll();
	}

}
