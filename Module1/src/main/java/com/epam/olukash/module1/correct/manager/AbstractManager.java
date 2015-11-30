package com.epam.olukash.module1.correct.manager;

/**
 * @author Oleksii_Lukash
 * @date 11/28/2015
 */
public interface  AbstractManager <T>
{
	void save(T bean);
	void update(T bean);
	T get(long id);
	void remove(T bean);
}
