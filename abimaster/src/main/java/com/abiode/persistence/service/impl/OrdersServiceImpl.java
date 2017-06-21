/**
 * 
 */
package com.abiode.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.abiode.dao.IOperations;
import com.abiode.dao.OrdersDAO;
import com.abiode.model.Orders;
import com.abiode.persistence.service.OrdersService;
import com.abiode.persistence.service.common.AbstractJpaService;

/**
 * @author jonev
 *
 */
public class OrdersServiceImpl extends AbstractJpaService<Orders> implements OrdersService  {

	@Autowired
	private OrdersDAO ordersDAO;
	
	public OrdersServiceImpl() {
		super();
	}
	
	@Override
	protected IOperations<Orders> getDao() {
		return ordersDAO;
	}
}
