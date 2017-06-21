/**
 * 
 */
package com.abiode.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author jonev
 *
 */
@Entity
@Table(name = "OE.ORDERS")
@SequenceGenerator(name = "ORDR_SEQ", sequenceName = "OE_ORDERS_ID", initialValue = 1, allocationSize = 1)
public class Orders extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2732993670795136617L;
	
	@Id
	@Column(name = "ORDER_ID")
	private Long orderId;
	
	@Column(name = "ORDER_DATE")
	private Timestamp orderDate;

	@Column(name = "ORDER_MODE")
	private String orderMode;

	@Column(name = "CUSTOMER_ID")
	private Long customerId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID", insertable=false, updatable=false)
	private Customers customers;

	@Column(name = "ORDER_STATUS")
	private Integer orderStatus;

	@Column(name = "ORDER_TOTAL")
	private Double orderTotal;

	@Column(name = "SALES_REP_ID")
	private Long salesRepId;
	
	@Column(name = "PROMOTION_ID")
	private Long promotionId;

	@OneToMany(mappedBy = "customerId")
	private List<Customers> customerList;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(orderId).append("\t");
		sb.append(orderDate).append("\t");
		sb.append(orderMode).append("\t");
		sb.append(customerId).append("\t");
		sb.append(orderStatus).append("\t");
		sb.append(orderTotal).append("\t");
		sb.append(salesRepId).append("\t");
		sb.append(promotionId).append("\t");
		//sb.append("\n");		
		return sb.toString();
	}
	
	/**
	 * @return the customers
	 */
	public Customers getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	
	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the orderDate
	 */
	public Timestamp getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the orderMode
	 */
	public String getOrderMode() {
		return orderMode;
	}

	/**
	 * @param orderMode the orderMode to set
	 */
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the orderStatus
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the orderTotal
	 */
	public Double getOrderTotal() {
		return orderTotal;
	}

	/**
	 * @param orderTotal the orderTotal to set
	 */
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	/**
	 * @return the salesRepId
	 */
	public Long getSalesRepId() {
		return salesRepId;
	}

	/**
	 * @param salesRepId the salesRepId to set
	 */
	public void setSalesRepId(Long salesRepId) {
		this.salesRepId = salesRepId;
	}

	/**
	 * @return the promotionId
	 */
	public Long getPromotionId() {
		return promotionId;
	}

	/**
	 * @param promotionId the promotionId to set
	 */
	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}

	/**
	 * @return the ordersList
	 */
	public List<Customers> getCustomerList() {
		return customerList;
	}

	/**
	 * @param ordersList the ordersList to set
	 */
	public void setCustomerList(List<Customers> customerList) {
		this.customerList = customerList;
	}
}

