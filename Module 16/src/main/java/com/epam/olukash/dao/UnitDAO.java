package com.epam.olukash.dao;

import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.Unit;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class UnitDAO extends AbstractDAO<Unit>
{
	protected Class<? extends AbstractBean> getClazz()
	{
		return Unit.class;
	}
}
