/**
 * 
 */
package com.abiode.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.abiode.model.Customers;
import com.abiode.model.Orders;

/**
 * @author jonev
 *
 */
public interface CustomerDAO extends IOperations<Customers> {
	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public List<Customers> getAllCustomers() throws HibernateException;
	
	/**
	 * 
	 * @param customerId
	 * @return
	 * @throws HibernateException
	 */
	public Customers getCustomerByCustomerId(Long customerId) throws HibernateException;
	
	/**
	 * 
	 * @param customerId
	 * @return
	 * @throws HibernateException
	 */
	public List<Customers> getCustomerByCustomerId(List<Long> customerId) throws HibernateException;
	
	/**
	 * 
	 * @param nlsterriroty
	 * @param maritalStatus
	 * @return
	 * @throws HibernateException
	 */
	public List<Customers> getCustomersByTerritoryAndStatus(String nlsterriroty, String maritalStatus) throws HibernateException;
	
	/**
	 * 
	 * @param customerId
	 * @return
	 * @throws HibernateException
	 */
	public void updateCustomerByCusomerId(Customers customer) throws HibernateException;
	
	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public List<Orders> getOrdersViaCustomersAndOrdersJoin() throws HibernateException;
	
	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public List<Customers> getAllCustomersInOrders() throws HibernateException;	
	
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws HibernateException
	 */
	public List<Orders> getAllOrdersInCustomers(String orderBy) throws HibernateException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public List<Orders>getOrdersViaCustomersAndOrdersJoinByCustomerId(Long id) throws HibernateException;
	
	/**
	 * 
	 * @param id
	 * @param orderBy
	 * @return
	 * @throws HibernateException
	 */
	public List<Orders>getOrdersViaCustomersAndOrdersJoinByCustomerIdAndOrderBy(Long id, String orderBy) throws HibernateException;
	
	/**
	 * 
	 * @param id
	 * @param orderBy
	 * @return
	 * @throws HibernateException
	 */
	public List<Orders>getOrdersViaCustomersAndOrdersJoinByCustomerIdListAndOrderBy(List<Long> id, String orderBy) throws HibernateException;
}
