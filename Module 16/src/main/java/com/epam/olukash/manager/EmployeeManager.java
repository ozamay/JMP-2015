package com.epam.olukash.manager;

import com.epam.olukash.dto.Employee;

/**
 * @author Oleksii.Lukash
 */
public interface EmployeeManager extends BeanManager<Employee>
{
	void addToUnit(long employeeID, long unitID);

	void assignToProject(long employeeID, long projectID);

}
