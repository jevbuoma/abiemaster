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
@Table(name = "OE.PRODUCT_DESCRIPTIONS")
@SequenceGenerator(name = "PRDDESC_SEQ", sequenceName = "OE_PRODUCT_ID", initialValue = 1, allocationSize = 1)
public class ProductDescription extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2732993670795136617L;
	
	@Id
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "LANGUAGE_ID")
	private Long languageId;

	@Column(name = "TRANSLATED_NAME")
	private String translatedName;

	@Column(name = "TRANSLATED_DESCRIPTION")
	private String translatedDescription;

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
	 * @return the languageId
	 */
	public Long getLanguageId() {
		return languageId;
	}

	/**
	 * @param languageId the languageId to set
	 */
	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	/**
	 * @return the translatedName
	 */
	public String getTranslatedName() {
		return translatedName;
	}

	/**
	 * @param translatedName the translatedName to set
	 */
	public void setTranslatedName(String translatedName) {
		this.translatedName = translatedName;
	}

	/**
	 * @return the translatedDescription
	 */
	public String getTranslatedDescription() {
		return translatedDescription;
	}

	/**
	 * @param translatedDescription the translatedDescription to set
	 */
	public void setTranslatedDescription(String translatedDescription) {
		this.translatedDescription = translatedDescription;
	}	
}

