/**
 * 
 */
package com.abiode.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author jonev
 *
 */
@Entity
@Table(name = "OE.CUSTOMERS")
@SequenceGenerator(name = "CUST_SEQ", sequenceName = "ASQ_CUSTOMER_ID", initialValue = 101, allocationSize = 1)
public class Customers extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	private Long customerId;
	
	@Column(name = "CUST_FIRST_NAME")
	private String custFirstName;

	@Column(name = "CUST_LAST_NAME")
	private String custLasttName;
/*	
	@Column(name = "CUST_ADDRESS")
	private String custAddress;
	
	@Column(name = "PHONE_NUMBERS")
	private String phoneNumbers;
*/	
	@Column(name = "NLS_LANGUAGE")
	private String nlsLanguage;

	@Column(name = "NLS_TERRITORY")
	private String nlsTerritory;

	@Column(name = "CREDIT_LIMIT")
	private BigDecimal credtLimit;

	@Column(name = "CUST_EMAIL")
	private String custEmail;

	@Column(name = "ACCOUNT_MGR_ID")
	private Long accountMgrId;
/*	
	@Column(name = "CUST_GEO_LOCAATION")
	private String custGeoLocation;
*/
	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	@Column (name = "MARITAL_STATUS")
	private String maritalStatus;
	
	@Column (name = "GENDER")
	private String gender;
	
	@Column(name = "INCOME_LEVEL")
	private String incomeLevel;
	
	@OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
	@OrderBy("customerId asc")
	private List<Orders> ordersList = new ArrayList<Orders>();
	
    // get first order ...	
	public Orders getFirstOrder() {
		if (ordersList != null) {
			for (Orders orders : ordersList) {
				if (orders != null) { 
					return orders;
				}
			}
		}
		return null;
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
	 * @return the custFirstName
	 */
	public String getCustFirstName() {
		return custFirstName;
	}

	/**
	 * @param custFirstName the custFirstName to set
	 */
	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	/**
	 * @return the custLasttName
	 */
	public String getCustLasttName() {
		return custLasttName;
	}

	/**
	 * @param custLasttName the custLasttName to set
	 */
	public void setCustLasttName(String custLasttName) {
		this.custLasttName = custLasttName;
	}

	/**
	 * @return the nlsLanguage
	 */
	public String getNlsLanguage() {
		return nlsLanguage;
	}

	/**
	 * @param nlsLanguage the nlsLanguage to set
	 */
	public void setNlsLanguage(String nlsLanguage) {
		this.nlsLanguage = nlsLanguage;
	}

	/**
	 * @return the nlsTerritory
	 */
	public String getNlsTerritory() {
		return nlsTerritory;
	}

	/**
	 * @param nlsTerritory the nlsTerritory to set
	 */
	public void setNlsTerritory(String nlsTerritory) {
		this.nlsTerritory = nlsTerritory;
	}

	/**
	 * @return the credtLimit
	 */
	public BigDecimal getCredtLimit() {
		return credtLimit;
	}

	/**
	 * @param credtLimit the credtLimit to set
	 */
	public void setCredtLimit(BigDecimal credtLimit) {
		this.credtLimit = credtLimit;
	}

	/**
	 * @return the custEmail
	 */
	public String getCustEmail() {
		return custEmail;
	}

	/**
	 * @param custEmail the custEmail to set
	 */
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	/**
	 * @return the accountMgrId
	 */
	public Long getAccountMgrId() {
		return accountMgrId;
	}

	/**
	 * @param accountMgrId the accountMgrId to set
	 */
	public void setAccountMgrId(Long accountMgrId) {
		this.accountMgrId = accountMgrId;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the maritalStatus
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the incomeLevel
	 */
	public String getIncomeLevel() {
		return incomeLevel;
	}

	/**
	 * @param incomeLevel the incomeLevel to set
	 */
	public void setIncomeLevel(String incomeLevel) {
		this.incomeLevel = incomeLevel;
	}

	/**
	 * @return the ordersList
	 */
	public List<Orders> getOrdersList() {
		return ordersList;
	}

	/**
	 * @param ordersList the ordersList to set
	 */
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}	
}
