/**
 * 
 */
package com.abiode.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.abiode.dao.ProductDescriptionDAO;
import com.abiode.dataaccess.AbstractJpaRepository;
import com.abiode.model.ProductDescription;
import com.abiode.model.ProductInformation;

/**
 * @author jonev
 *
 */
@Repository
public class ProducDescriptionDAOImpl extends AbstractJpaRepository implements ProductDescriptionDAO {

	/* (non-Javadoc)
	 * @see com.abiode.dao.ProductService#getAllProductDescriptions()
	 */
	@Override
	public List<ProductDescription> getAllProductDescriptions() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.abiode.dao.ProductService#getProductDescriptionByProductId(java.lang.Long)
	 */
	@Override
	public ProductDescription getProductDescriptionByProductId(Long productId) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.abiode.dao.ProductService#getFirstProductionDescription()
	 */
	@Override
	public ProductDescription getFirstProductionDescription() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductInformation> getAllProductInformation() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductInformation getProductInformationByProductId(Long productId) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductInformation getFirstProductionInformation() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDescription findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDescription> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(ProductDescription entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductDescription update(ProductDescription entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ProductDescription entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long entityId) {
		// TODO Auto-generated method stub
		
	}
}
