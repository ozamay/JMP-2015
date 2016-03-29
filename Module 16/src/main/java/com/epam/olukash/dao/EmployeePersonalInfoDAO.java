package com.epam.olukash.dao;

import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.EmployeePersonalInfo;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class EmployeePersonalInfoDAO extends AbstractDAO<EmployeePersonalInfo>
{
	protected Class<? extends AbstractBean> getClazz()
	{
		return EmployeePersonalInfo.class;
	}
}
