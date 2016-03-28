package com.epam.olukash.manager;

import java.util.List;

import com.epam.olukash.dto.AbstractBean;

/**
 * @author Oleksii.Lukash
 */
public interface BeanManager<T extends AbstractBean>
{
	long save(T bean);

	T find(long id);

	void update(T bean);

	void remove(long id);

	List<T> findAll();
}
