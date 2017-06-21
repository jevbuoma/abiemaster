/**
 * 
 */
package com.abiode.manager;

import java.util.List;

import com.abiode.bo.CustomerBO;

/**
 * @author jonev
 *
 */
public interface CustomerManager {
	/**
	 * 
	 * @return
	 */
	public List<CustomerBO> getAllCustomerBO();
	
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public CustomerBO getCustomerBOById(Long customerId);
}
