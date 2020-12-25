/**
 * 
 */
package com.mcare.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcare.server.repository.CustomerCareRepository;

/**
 * @author user
 *
 */
@Service 
public class CustomerCareService {

	private static Logger logger = LoggerFactory.getLogger(CustomerCareService.class);

	@Autowired
	private CustomerCareRepository customerCareRepository;
	
	private String customerCareNumbers = "";
	
 
	public CustomerCareService(){
		logger.info("In::");
		
	}

	public String getCustomerCareNumbers() {
		if(customerCareNumbers.equals("") ){
			customerCareRepository.findAll().forEach(customerCare -> customerCareNumbers += customerCare!= null ? customerCare.getNumber()+ " ": "");
	    }
		return customerCareNumbers;
	}

	public void setCustomerCareNumbers(String customerCareNumbers) {
		this.customerCareNumbers = customerCareNumbers;
	}
	
	
	 

}
