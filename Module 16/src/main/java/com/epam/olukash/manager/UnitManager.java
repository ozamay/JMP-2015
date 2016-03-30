package com.epam.olukash.manager;

import com.epam.olukash.dto.Unit;

/**
 * @author Oleksii.Lukash
 */
public interface UnitManager extends BeanManager<Unit>
{
	void addToUnit(long employeeID, long unitID);
}
