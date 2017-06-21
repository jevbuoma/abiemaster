package com.abiode.persistence;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.abiode.bo.CustomerBO;
import com.abiode.dao.CustomerDAO;
import com.abiode.dataaccess.AbstractJpaRepository;
import com.abiode.manager.CustomerManager;
import com.abiode.model.Customers;
import com.abiode.model.Orders;
import com.abiode.spring.PersistenceConfig;
import com.abiode.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class CustomerJpa extends AbstractJpaRepository {

	@Autowired
	private CustomerManager customerManager;

	@Autowired
	CustomerDAO customerDAO;
			
	@Test
	public void getOrdersViaCustomersAndOrdersJoinTest() {
		// Retrieve customers that have the same customer_id in orders table...
		List<Orders> ordersList = customerDAO.getOrdersViaCustomersAndOrdersJoin();
		System.out.println("Orders Join Count: "+ordersList.size());
		assertEquals(ordersList.size(), 106);
	}
	
	@Test
	public void getOrdersViaCustomersAndOrdersJoinByCustomerIdTest() {
		List<Orders> ordersList = customerDAO.getOrdersViaCustomersAndOrdersJoinByCustomerId(101L);
		System.out.println("!!!Orders Join By Id Count: "+ordersList.size());
		System.out.println("\n\n");
		assertEquals(ordersList.size(), 4);
	}
	
	@Test
	public void getOrdersViaCustomersAndOrdersJoinByCustomerIdAndOrderByTest() {
		List<Orders> ordersList = 
				customerDAO.getOrdersViaCustomersAndOrdersJoinByCustomerIdAndOrderBy(101L, "customerId");
		System.out.println("~~~Orders Join By Id And Order By Count: "+ordersList.size());
		System.out.println("\n\n");
		assertEquals(ordersList.size(), 4);
	}
	
	@Test
	public void getOrdersViaCustomersAndOrdersJoinByCustomerIdListAndOrderByTest() {
		List<Long> custIdList = new ArrayList<Long>();
		custIdList.add(104L);
		custIdList.add(101L);
		custIdList.add(117L);
		custIdList.add(146L);
		custIdList.add(153L);
		List<Orders> ordersList = 
				customerDAO.getOrdersViaCustomersAndOrdersJoinByCustomerIdListAndOrderBy(custIdList, "customerId");
		System.out.println("^^^Orders Join By Id List And Order By Count: "+ordersList.size());
		System.out.println("\n\n");
		assertEquals(ordersList.size(), 18);
	}
	
	@Test
	public void getCustomersByTerritoryAndStatusTest() {
		List<Customers> customerList = customerDAO.getCustomersByTerritoryAndStatus("AMERICA", "married");
		assertEquals(customerList.size(), 102);
	}
	
	@Test
	public void getCustomerByIdTest() {
		CustomerBO customerBO = customerManager.getCustomerBOById(123L);
		System.out.println("Customer 123 credit limit: "+customerBO.getCreditLimit());
		assertEquals(customerBO.getLastName(), "Brown");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getAmericaCustomersCountTest() {
		List<Integer> results = getSession().createCriteria(Customers.class)
				.add(Restrictions.eq("nlsTerritory", "AMERICA")).list();
		assertEquals(results.size(), 184);
	}
		
	@Test
	public void updateCustomerByIdViaCreateQuery() {
		Long customerId = 145L;
		BigDecimal bg = new BigDecimal(570);
		String incomeLevel="E: 100,000 - 109,999";
		Timestamp createdDate = DateUtil.getCurrentDate();
		Timestamp lastUpdatedDate = DateUtil.getCurrentDate();
		Long lastUpdatedBy = 2L;
		String source = System.getProperty("user.name");
		
		String sqlStr = "Update Customers SET CREDIT_LIMIT = :bg, INCOME_LEVEL = :incomeLevel, "
				+ "TYT_CREATED_DT = :createdDate, TYT_SOURCE = :source,"
						+ " TYT_LAST_UPDATED_BY = :lastUpdatedBy,"
						+ " TYT_LAST_UPDATED_DT = :lastUpdatedDate where CUSTOMER_ID = :customerId";
		
		Query query = getSession().createQuery(sqlStr);
		query.setString("incomeLevel",incomeLevel);
		query.setBigDecimal("bg", bg);
		query.setTimestamp("createdDate", createdDate);
		query.setLong("customerId", customerId);
		query.setTimestamp("lastUpdatedDate", lastUpdatedDate);
		query.setLong("lastUpdatedBy", lastUpdatedBy);
		query.setString("source",source);
		
		query.executeUpdate();
		getSession().getTransaction().commit();
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void updateCustomerByIdTest() {
		// attempt to retrieve a specific customer record ...
		Long customerId = 159L;
		List<Customers> customers = getSession().createCriteria(Customers.class)
				.add(Restrictions.eq("customerId", customerId)).list();
		Customers customer = customers.get(0);
		customer.setCredtLimit(new BigDecimal(600));
		customer.setIncomeLevel("F: 110,000 - 129,999");
		customer.setCustEmail("ed.boyer@patcheko.net");
		customer.setSource(System.getProperty("user.name"));
		customer.setLastUpdatedBy(3L);
		customer.setLastUpdatedDt(DateUtil.getCurrentDate());
		try {
			customer.setCreatedDt(DateUtil.addDaytoTS(DateUtil.getCurrentDate(), 50));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		getSession().update(customer);
		getSession().getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getAllCustomersTest() {
		List<Customers> customerList = getSession().createCriteria(Customers.class).list();
		assertEquals(customerList.size(), 319);
	}
	
	@Test
	public void getCustomerByCustomerIdTest() {
		// commnent to initiate diff reaction to cloned repo ..
		List<Long> customerIdList = new ArrayList<Long>(5);
		customerIdList.add(189L);
		customerIdList.add(217L);
		customerIdList.add(141L);
		customerIdList.add(153L);
		customerIdList.add(199L);
		List<Customers> customerList = customerDAO.getCustomerByCustomerId(customerIdList);
		Customers customer = customerList.get(0);
		String name1 = "Maximilian Henner";
		String name2 = customer.getCustFirstName()+" "+customer.getCustLasttName();
		assertEquals(name1, name2);		
	}
	
	@Test
	public void getAllOrdersInCustomersTest() {
		List<Customers> customerList = customerDAO.getAllCustomersInOrders();
		Long custId1 = 101L;
		Long custId2 = 0L;
		if (customerList != null) {
			for (Customers customer : customerList) {
				custId2 = customer.getCustomerId();
				break;
			}
		}
		assertEquals(custId1, custId2);
	}	
}
