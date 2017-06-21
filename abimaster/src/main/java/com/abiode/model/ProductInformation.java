/**
 * 
 */
package com.abiode.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author jonev
 *
 */
@Entity
@Table(name = "OE.PRODUCT_INFORMATION")
@SequenceGenerator(name = "PRDDINFO_SEQ", sequenceName = "OE_PRODUCT_ID", initialValue = 1, allocationSize = 1)
public class ProductInformation extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2732993670795136617L;
	
	@Id
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "PRODUCT_NAME")
	private Long productName;

	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name = "CATEGORY_ID")
	private String categoryId;
	
	@Column(name = "WEIGHT_CLASS")
	private String weightClass;

	@Column(name = "SUPPLIER_ID")
	private String supplierId;
	
	@Column(name = "PRODUCT_STATUS")
	private String productStatus;

	@Column(name = "LIST_PRICE")
	private String listPrice;

	@Column(name = "MIN_PRICE")
	private String minPrice;

	@Column(name = "CATALOG_URL")
	private String catalogUrl;

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
	 * @return the productName
	 */
	public Long getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(Long productName) {
		this.productName = productName;
	}

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the weightClass
	 */
	public String getWeightClass() {
		return weightClass;
	}

	/**
	 * @param weightClass the weightClass to set
	 */
	public void setWeightClass(String weightClass) {
		this.weightClass = weightClass;
	}

	/**
	 * @return the supplierId
	 */
	public String getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the productStatus
	 */
	public String getProductStatus() {
		return productStatus;
	}

	/**
	 * @param productStatus the productStatus to set
	 */
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	/**
	 * @return the listPrice
	 */
	public String getListPrice() {
		return listPrice;
	}

	/**
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(String listPrice) {
		this.listPrice = listPrice;
	}

	/**
	 * @return the minPrice
	 */
	public String getMinPrice() {
		return minPrice;
	}

	/**
	 * @param minPrice the minPrice to set
	 */
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	/**
	 * @return the catalogUrl
	 */
	public String getCatalogUrl() {
		return catalogUrl;
	}

	/**
	 * @param catalogUrl the catalogUrl to set
	 */
	public void setCatalogUrl(String catalogUrl) {
		this.catalogUrl = catalogUrl;
	}	
}

