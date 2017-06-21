/**
 * 
 */
package com.abiode.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author jonev
 *
 */
@Entity
@Table(name = "OE.ORDER_ITEMS")
@SequenceGenerator(name = "ORDRITM_SEQ", sequenceName = "OE_ORDERS_ID", initialValue = 1, allocationSize = 1)
public class OrderItems extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2732993670795136617L;
	
	@Id
	@Column(name = "ORDER_ID")
	private Long orderId;
	
	@Column(name = "LINE_ITEM_ID")
	private Long lineItemId;

	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "UNIT_PRICE")
	private BigDecimal unitPrice;

	@Column(name = "QUANTITY")
	private Long quantity;

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
	 * @return the lineItemId
	 */
	public Long getLineItemId() {
		return lineItemId;
	}

	/**
	 * @param lineItemId the lineItemId to set
	 */
	public void setLineItemId(Long lineItemId) {
		this.lineItemId = lineItemId;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the unitPrice
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@OneToMany(mappedBy = "productId")
	private List<ProductDescription> productDescriptionList = new ArrayList<ProductDescription>();	
	
	@OneToMany(mappedBy = "productId")
	private List<ProductInformation> productInformationist = new ArrayList<ProductInformation>();	
	
}

