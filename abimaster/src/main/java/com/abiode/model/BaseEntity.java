package com.abiode.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Entity implementation class for Entity: BaseEntity
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	@Column(name="TYT_SOURCE")
	private String source;

	@Column(name="TYT_CREATED_DT")
	private Timestamp createdDt;

	@Column(name="TYT_LAST_UPDATED_BY")
	private Long lastUpdatedBy;

	@Column(name="TYT_LAST_UPDATED_DT")
	private Timestamp lastUpdatedDt;
	
	private static final long serialVersionUID = 1L;

	public BaseEntity() {
		super();
	}   
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Timestamp createdDt) {
		this.createdDt = createdDt;
	}

	public Timestamp getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Timestamp lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}
}
