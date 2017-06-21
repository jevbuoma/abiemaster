/**
 * 
 */
package com.abiode.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.abiode.dao.CustomerDAO;
import com.abiode.dao.IOperations;
import com.abiode.model.Customers;
import com.abiode.persistence.service.CustomerService;
import com.abiode.persistence.service.common.AbstractJpaService;

/**
 * @author jonev
 *
 */
public class CustomerServiceImpl  extends AbstractJpaService<Customers> implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	public CustomerServiceImpl() {
		super();
	}
	
	@Override
	protected IOperations<Customers> getDao() {
		return customerDAO;
	}
}
