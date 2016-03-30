package com.epam.olukash.dao;

import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.Employee;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class EmployeeDAO extends AbstractDAO<Employee>
{

	protected Class<? extends AbstractBean> getClazz()
	{
		return Employee.class;
	}
}
