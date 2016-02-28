package com.epam.olukash.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import com.epam.olukash.dao.AbstractDAO;
import com.epam.olukash.dto.AbstractBean;

/**
 * @author Oleksii.Lukash
 */
public abstract class AbstractManager<T extends AbstractBean, V extends AbstractDAO<T>> implements BeanManager<T>
{
	@Autowired
	protected V beanDAO;

	@Override
	public void save(T bean)
	{
		beanDAO.save(bean);
	}

	@Override
	public T find(int id)
	{
		return beanDAO.find(id);
	}

	@Override
	public void save(List<T> beans)
	{
		beanDAO.save(beans);
	}

	@Override
	public List<T> findAll()
	{
		return beanDAO.findAll();
	}

	@Override
	public void remove(int id)
	{
		beanDAO.remove(id);
	}

}
