package com.epam.olukash.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.olukash.dao.AbstractDAO;
import com.epam.olukash.dto.AbstractBean;

/**
 * @author Oleksii.Lukash
 */
@Transactional
public abstract class AbstractManager<T extends AbstractBean, V extends AbstractDAO<T>> implements BeanManager<T>
{
	@Autowired
	protected V beanDAO;

	public long save(T bean)
	{
		return beanDAO.save(bean);
	}

	public T find(long id)
	{
		return beanDAO.find(id);
	}

	public void update(T bean)
	{
		beanDAO.update(bean);
	}

	public void remove(long id)
	{
		beanDAO.delete(id);
	}

	public List<T> findAll()
	{
		return beanDAO.findAll();
	}
}
