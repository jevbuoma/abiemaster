/**
 * 
 */
package com.abiode.dataaccess;

/**
 * @author jonev
 *
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description : This class creates JPA Session.
 *   This is the base class and if extended returns the session and methods to do CRUD operations on the entities.
 *
 */
@Transactional (value = "jpaTransactionManager")
public abstract class AbstractJpaRepository {
	
	@Autowired
    private EntityManager em;

    @PersistenceContext
    protected void setEntityManager(EntityManager em) {
        this.em = em;
    }

    protected EntityManager getEm() {
        return em;
    }

    @Transactional
    protected Session getSession() {
        return (Session) em.getDelegate();
    }

    @Transactional
    protected Query createQuery(String s) {
        return getSession().createQuery(s);
    }

    @Transactional
    protected void persist(Object obj) {
        getSession().persist(obj);
    }

    @Transactional
    protected void merge(Object obj) {
        getSession().merge(obj);
    }

    @Transactional
    public void remove(Object obj) {
        getSession().delete(obj);
    }

    @Transactional
    public void refresh(Object obj) {
        getSession().refresh(obj);
    }

    @Transactional
    public SQLQuery createSQLQuery(String nativeSQL) {
        return getSession().createSQLQuery(nativeSQL);
    }
}

