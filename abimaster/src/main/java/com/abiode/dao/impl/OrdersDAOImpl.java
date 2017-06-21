/**
 * 
 */
package com.abiode.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.abiode.dao.OrdersDAO;
import com.abiode.dataaccess.AbstractJpaRepository;
import com.abiode.model.OrderItems;
import com.abiode.model.Orders;

/**
 * @author jonev
 *
 */
@Repository
public class OrdersDAOImpl extends AbstractJpaRepository implements OrdersDAO {

	/* (non-Javadoc)
	 * @see com.abiode.dao.OrdersDB#getAllOrderItems()
	 */
	@Override
	public List<OrderItems> getAllOrderItems() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.abiode.dao.OrdersDB#getOrderItemByOrderId(java.lang.Long)
	 */
	@Override
	public OrderItems getOrderItemByOrderId(Long orderId) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.abiode.dao.OrdersDB#getOrderItemByProductId(java.lang.Long)
	 */
	@Override
	public OrderItems getOrderItemByProductId(Long productId) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.abiode.dao.OrdersDB#getOrderItemByOrderIdAndProductId(java.lang.Long, java.lang.Long)
	 */
	@Override
	public OrderItems getOrderItemByOrderIdAndProductId(Long orderId, Long productId) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.abiode.dao.OrdersDB#getAllOrders()
	 */
	@Override
	public List<Orders> getAllOrders() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.abiode.dao.OrdersDB#getOrderByOrderId(java.lang.Long)
	 */
	@Override
	public Orders getOrderByOrderId(Long orderId) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.abiode.dao.OrdersDB#getOrderByProductId(java.lang.Long)
	 */
	@Override
	public Orders getOrderByProductId(Long productId) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.abiode.dao.OrdersDB#getOrderByOrderIdAndProductId(java.lang.Long, java.lang.Long)
	 */
	@Override
	public Orders getOrderByOrderIdAndProductId(Long orderId, Long productId) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Orders entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orders update(Orders entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Orders entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long entityId) {
		// TODO Auto-generated method stub
		
	}

}
