/**
 * 
 */
package com.abiode.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.abiode.model.ProductDescription;
import com.abiode.model.ProductInformation;

/**
 * @author jonev
 *
 */
public interface ProductDescriptionDAO extends IOperations<ProductDescription>{
	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public List<ProductDescription> getAllProductDescriptions() throws HibernateException;
	
	/**
	 * 
	 * @param productId
	 * @return
	 * @throws HibernateException
	 */
	public ProductDescription getProductDescriptionByProductId(Long productId) throws HibernateException;
	
	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public ProductDescription getFirstProductionDescription() throws HibernateException;
	
	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public List<ProductInformation> getAllProductInformation() throws HibernateException;
	
	/**
	 * 
	 * @param productId
	 * @return
	 * @throws HibernateException
	 */
	public ProductInformation getProductInformationByProductId(Long productId) throws HibernateException;
	
	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public ProductInformation getFirstProductionInformation() throws HibernateException;
}