/**
 * 
 */
package com.abiode.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abiode.bo.CustomerBO;
import com.abiode.dao.CustomerDAO;
import com.abiode.manager.CustomerManager;
import com.abiode.model.Customers;

/**
 * @author jonev
 *
 */
@Component
public class CustomerManagerImpl implements CustomerManager {

	@Autowired
	CustomerDAO customerDAO;
	
	/* (non-Javadoc)
	 * @see com.abiode.manager.CustomerManager#getAllCustomerBO()
	 */
	@Override
	public List<CustomerBO> getAllCustomerBO() {
		List<Customers> customerList = customerDAO.getAllCustomers();
		List<CustomerBO> customerBOList = new ArrayList<CustomerBO>(customerList.size());		
		for (Customers customer : customerList) {
			CustomerBO customerBO = loadCustomerBO(customer);
			customerBOList.add(customerBO);
		}
		return customerBOList;
	}

	/* (non-Javadoc)
	 * @see com.abiode.manager.CustomerManager#getCustomerBOById(java.lang.Long)
	 */
	@Override
	public CustomerBO getCustomerBOById(Long customerId) {
		Customers customer = customerDAO.getCustomerByCustomerId(customerId);
		return loadCustomerBO(customer);
	}

	/**
	 * 
	 * @param customer
	 * @return
	 */
	private CustomerBO loadCustomerBO(Customers customer) {
		CustomerBO customerBO = new CustomerBO();
		customerBO.setCreditLimit(customer.getCredtLimit());
		customerBO.setCustomerId(customer.getCustomerId());
		customerBO.setDateOfBirth(customer.getDateOfBirth());
		customerBO.setEmail(customer.getCustEmail());
		customerBO.setFirstName(customer.getCustFirstName());
		customerBO.setGender(customer.getGender());
		customerBO.setLastName(customer.getCustLasttName());
		customerBO.setMaritalStatus(customer.getMaritalStatus());
		
		return customerBO;
	}
}
