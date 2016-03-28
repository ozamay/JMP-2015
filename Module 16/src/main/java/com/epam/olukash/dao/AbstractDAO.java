package com.epam.olukash.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

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
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Long id = (Long) session.save(bean);
		tx.commit();
		session.close();

		return id;
	}

	public T find(Long beanID)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		T bean = (T) session.get(getClazz(), beanID);
		tx.commit();
		session.close();
		return bean;
	}

	public void update(T bean)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(bean);
		tx.commit();
		session.close();
	}

	public void delete(Long beanID)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		T bean = (T) session.get(getClazz(), beanID);
		session.delete(bean);
		tx.commit();
		session.close();
	}

	public List<T> findAll()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<T> beans = (List<T>) session.createCriteria(getClazz()).list();
		tx.commit();
		session.close();
		return beans;
	}

	protected abstract Class<? extends AbstractBean> getClazz();
}
