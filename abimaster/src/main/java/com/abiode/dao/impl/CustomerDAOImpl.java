/**
 * 
 */
package com.abiode.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.abiode.dao.CustomerDAO;
import com.abiode.dataaccess.AbstractJpaRepository;
import com.abiode.model.Customers;
import com.abiode.model.Orders;

/**
 * @author jonev
 *
 */

@Repository
public class CustomerDAOImpl extends AbstractJpaRepository implements CustomerDAO{

	@Override
	public List<Customers> getAllCustomers() throws HibernateException {
		Orders orders = new Orders();
		return orders.getCustomerList();
	}

	@Override
	public Customers getCustomerByCustomerId(Long customerId) throws HibernateException {
		Customers customer = null;
		Session session = getSession();
		@SuppressWarnings("unchecked")
		List<Customers> customers = session.createCriteria(Customers.class)
			.add(Restrictions.eq("customerId", customerId)).list();
		
		if (customers != null && customers.size()>0)
			customer = customers.get(0);
		return customer;
	}

	@Override
	public void updateCustomerByCusomerId(Customers customer)  {
		try {
			Session session = getSession();
			session.update(customer);
			session.getTransaction().commit();
		}
		catch(HibernateException hibEx) {
			System.out.println("HibernateException: "+hibEx.getMessage());
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customers> getCustomersByTerritoryAndStatus(String nlsterriroty, String maritalStatus)
			throws HibernateException {
		// Solve using Map ..
		Map<String, String> criteriaMap = new HashMap<String, String>();
		criteriaMap.put("nlsTerritory", nlsterriroty);
		criteriaMap.put("maritalStatus", maritalStatus);
		List<Customers> customerList = getSession().createCriteria(Customers.class)
				.add(Restrictions.allEq(criteriaMap)).list();
		System.out.println("Query Customers Result size: "+customerList.size());
		return customerList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customers> getCustomerByCustomerId(List<Long> customerId) throws HibernateException {
		List<Customers> customerList = getSession().createCriteria(Customers.class)
				.add(Restrictions.in("customerId", customerId))
				.addOrder(Order.asc("customerId")).list();
		return customerList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customers> getAllCustomersInOrders() throws HibernateException {		
		List<Orders> ordersList = getSession().createCriteria(Orders.class)
				.addOrder(Order.asc("customerId")).list();
		List<Customers> customerList = new ArrayList<Customers>();
		for (Orders order : ordersList) {
			List<Customers> custLst = getSession().createCriteria(Customers.class)
					.add(Restrictions.eq("customerId", order.getCustomerId()))
					.addOrder(Order.asc("customerId")).list();
			customerList.addAll(custLst);
		}
		if (customerList != null) {
			StringBuilder sb = new StringBuilder();
			int index = 0;
			for (Customers customer : customerList) {
				if (index % 10 == 0) 
					sb.append("\n");
				sb.append(customer.getCustomerId()+" ");
				index++;
			}
			System.out.println(sb.toString());
			System.out.println("***Orders in Customer Join size: "+customerList.size());
		}
			
		return customerList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getOrdersViaCustomersAndOrdersJoinByCustomerId(Long id) throws HibernateException {
		List<Orders> orderList = getSession().createCriteria(Orders.class)
				.setFetchMode("Customers", FetchMode.JOIN).add(Restrictions.eq("customerId", id)).list();		
		if (orderList != null) {
			for (Orders order : orderList) {
				System.out.println(order.toString());
			}
			System.out.println("*Orders in Customer size: "+orderList.size());
		}		
		return orderList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getOrdersViaCustomersAndOrdersJoinByCustomerIdAndOrderBy(Long id, String orderBy)
			throws HibernateException {
		List<Orders> orderList = getSession().createCriteria(Orders.class)
				.setFetchMode("Customers", FetchMode.JOIN)
				.add(Restrictions.eq("customerId", id))
				.addOrder(Order.desc(orderBy)).list();		
		if (orderList != null) {
			for (Orders order : orderList) {
				System.out.println(order.toString());
			}
			System.out.println("!Orders in Customer size: "+orderList.size());
		}		
		return orderList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getOrdersViaCustomersAndOrdersJoinByCustomerIdListAndOrderBy(List<Long> id, String orderBy)
			throws HibernateException {
		List<Orders> orderList = getSession().createCriteria(Orders.class)
				.setFetchMode("Customers", FetchMode.JOIN)
				.add(Restrictions.in("customerId", id))
				.addOrder(Order.desc(orderBy)).list();		
		if (orderList != null) {
			for (Orders order : orderList) {
				System.out.println(order.toString());
			}
			System.out.println("~Orders in Customer size: "+orderList.size());
		}		
		return orderList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getAllOrdersInCustomers(String orderBy) throws HibernateException {
		List<Orders> ordersList = getSession().createCriteria(Orders.class, "orders")
				.createAlias("orders.customerId", "customers")
				.add(Restrictions.eq("customerId", "orders.customerId"))
				.addOrder(Order.asc(orderBy)).list();
		System.out.println("!!!Orders lits count: "+ordersList.size());
		return ordersList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getOrdersViaCustomersAndOrdersJoin() throws HibernateException {
		List<Orders> orderList = getSession().createCriteria(Orders.class)
				.setFetchMode("Customers", FetchMode.JOIN).addOrder(Order.asc("customerId")).list();		
		if (orderList != null) {
			for (Orders order : orderList) {
				System.out.println(order.toString());
			}
			System.out.println("Orders in Customer size: "+orderList.size());
		}		
		return orderList;
	}
	
	@Override
	public Customers findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customers> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Customers entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customers update(Customers entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Customers entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long entityId) {
		// TODO Auto-generated method stub
		
	}
}
