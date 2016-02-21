package com.epam.olukash.manager;

import java.util.List;

import com.epam.olukash.dto.AbstractBean;

/**
 * @author Oleksii.Lukash
 */
public interface BeanManager<T extends AbstractBean>
{
	public void save(T bean);

	public void save(List<T> beans);

	public T find(int id);

	public List<T> findAll();

	public void remove(int id);
}
