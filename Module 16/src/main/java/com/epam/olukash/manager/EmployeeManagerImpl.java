package com.epam.olukash.manager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.olukash.dao.EmployeeDAO;
import com.epam.olukash.dto.Employee;
import com.epam.olukash.dto.EmployeePersonalInfo;
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
	protected EmployeePersonalInfoManager personalInfoManager;

	public void addToUnit(long employeeID, long unitID)
	{
		Unit unit = unitManager.find(unitID);
		Employee employee = find(employeeID);

		if (unit != null && employee != null)
		{
			employee.setUnit(unit);
			update(employee);
		}
	}

	public void assignToProject(long employeeID, long projectID)
	{
		Project project = projectManager.find(projectID);
		Employee employee = find(employeeID);

		if (project != null && employee != null)
		{
			if(employee.getProjects() == null)
			{
				Set<Project> projects = new HashSet<>();
				projects.add(project);
				employee.setProjects(projects);
			}
			else
			{
				employee.getProjects().add(project);
			}

			update(employee);
		}
	}
}
