/**
 * 
 */
package com.abiode.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.abiode.model.OrderItems;
import com.abiode.model.Orders;

/**
 * @author jonev
 *
 */
public interface OrdersDAO extends IOperations<Orders> {
	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public List<OrderItems> getAllOrderItems() throws HibernateException;
	
	/**
	 * 
	 * @param orderId
	 * @return
	 * @throws HibernateException
	 */
	public OrderItems getOrderItemByOrderId(Long orderId) throws HibernateException;
	
	/**
	 * 
	 * @param productId
	 * @return
	 * @throws HibernateException
	 */
	public OrderItems getOrderItemByProductId(Long productId) throws HibernateException;
	
	/**
	 * 
	 * @param orderId
	 * @param productId
	 * @return
	 * @throws HibernateException
	 */
	public OrderItems getOrderItemByOrderIdAndProductId(Long orderId, Long productId) throws HibernateException;
	
	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public List<Orders> getAllOrders() throws HibernateException;
	
	/**
	 * 
	 * @param orderId
	 * @return
	 * @throws HibernateException
	 */
	public Orders getOrderByOrderId(Long orderId) throws HibernateException;
	
	/**
	 * 
	 * @param productId
	 * @return
	 * @throws HibernateException
	 */
	public Orders getOrderByProductId(Long productId) throws HibernateException;
	
	/**
	 * 
	 * @param orderId
	 * @param productId
	 * @return
	 * @throws HibernateException
	 */
	public Orders getOrderByOrderIdAndProductId(Long orderId, Long productId) throws HibernateException;
}
