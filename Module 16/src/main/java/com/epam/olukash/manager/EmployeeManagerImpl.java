package com.epam.olukash.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.olukash.dao.EmployeeDAO;
import com.epam.olukash.dto.Employee;
import com.epam.olukash.dto.Project;
import com.epam.olukash.dto.Unit;

/**
 * @author Oleksii.Lukash
 */
public class EmployeeManagerImpl extends AbstractManager<Employee, EmployeeDAO> implements EmployeeManager
{
	@Autowired
	protected UnitManager unitManager;

	@Autowired
	protected ProjectManager projectManager;

	@Autowired
	protected EmployeePersonalInfoManager2 personalInfoManager;

	@Transactional
	public void addToUnit(long employeeID, long unitID)
	{
		Unit unit = unitManager.find(5);
		Employee employee = find(employeeID);

		if (unit != null && employee != null)
		{
			employee.setUnit(unit);
			update(employee);
		}
	}

	@Transactional
	public void assignToProject(long employeeID, long projectID)
	{
		Project project = projectManager.find(projectID);
		Employee employee = find(employeeID);

		if (project != null && employee != null)
		{
			employee.getProjects().add(project);
			update(employee);
		}
	}
}
