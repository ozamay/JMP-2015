package com.epam.olukash.manager;

import java.util.List;

/**
 * @author Oleksii.Lukash
 */
public interface BeanManager<T>
{
	long save(T bean);

	T find(long id);

	void update(T bean);

	void remove(long id);

	List<T> findAll();
}
