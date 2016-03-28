package com.epam.olukash.manager;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.olukash.dao.UnitDAO;
import com.epam.olukash.dto.Employee;
import com.epam.olukash.dto.Unit;

/**
 * @author Oleksii.Lukash
 */
public class UnitManagerImpl extends AbstractManager<Unit, UnitDAO> implements UnitManager
{
	@Autowired
	protected EmployeeManager employeeManager;

	public void addToUnit(long employeeID, long unitID)
	{
		Employee employee = employeeManager.find(employeeID);
		Unit unit = find(unitID);
		employee.setUnit(unit);
	}
}
