package com.epam.olukash.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.olukash.dto.AbstractBean;

/**
 * @author Oleksii.Lukash
 */
public abstract class AbstractDAO<T>
{
	private static final Logger logger = Logger.getLogger(AbstractDAO.class);

	@Autowired
	protected SessionFactory sessionFactory;

	public Long save(T bean)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			return (Long) session.save(bean);
		}
		catch (Exception e)
		{
			logger.error("Error saving bean of type " + getClazz());
			throw new DAOException("Error saving bean of type " + getClazz(), e);
		}
	}

	public T find(Long beanID)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			T bean = (T) session.get(getClazz(), beanID);
			return bean;
		}
		catch (Exception e)
		{
			logger.error("Error finding bean of type " + getClazz());
			throw new DAOException("Error finding bean of type " + getClazz(), e);
		}
	}

	public void update(T bean)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(bean);
		}
		catch (Exception e)
		{
			logger.error("Error updating bean of type " + getClazz());
			throw new DAOException("Error updating bean of type " + getClazz(), e);
		}
	}

	public void delete(Long beanID)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			T bean = (T) session.get(getClazz(), beanID);
			session.delete(bean);
		}
		catch (Exception e)
		{
			logger.error("Error removing bean of type " + getClazz());
			throw new DAOException("Error removing bean of type " + getClazz(), e);
		}
	}

	public List<T> findAll()
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			List<T> beans = (List<T>) session.createCriteria(getClazz()).list();
			return beans;
		}
		catch (Exception e)
		{
			logger.error("Error getting all beans of type " + getClazz());
			throw new DAOException("Error getting all beans of type " + getClazz(), e);
		}
	}

	protected abstract Class<? extends AbstractBean> getClazz();
}
