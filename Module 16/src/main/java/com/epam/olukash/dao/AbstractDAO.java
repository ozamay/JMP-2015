package com.epam.olukash.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.olukash.dto.AbstractBean;

/**
 * @author Oleksii.Lukash
 */
public abstract class AbstractDAO<T>
{
	@Autowired
	protected SessionFactory sessionFactory;

	public Long save(T bean)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Long id = (Long) session.save(bean);
		tx.commit();

		return id;
	}

	public T find(Long beanID)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		T bean = (T) session.get(getClazz(), beanID);
		tx.commit();
		return bean;
	}

	public void update(T bean)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(bean);
		tx.commit();
	}

	public void delete(Long beanID)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		T bean = (T) session.get(getClazz(), beanID);
		session.delete(bean);
		tx.commit();
	}

	public List<T> findAll()
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<T> beans = (List<T>) session.createCriteria(getClazz()).list();
		tx.commit();
		return beans;
	}

	protected abstract Class<? extends AbstractBean> getClazz();
}
