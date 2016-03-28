package com.epam.olukash.bp;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.olukash.dto.Address;
import com.epam.olukash.dto.Employee;
import com.epam.olukash.dto.EmployeePersonalInfo;
import com.epam.olukash.dto.EmployeeStatus;
import com.epam.olukash.dto.Project;
import com.epam.olukash.dto.Unit;
import com.epam.olukash.manager.EmployeeManager;
import com.epam.olukash.manager.EmployeeManagerImpl;
import com.epam.olukash.manager.EmployeePersonalInfoManager;
import com.epam.olukash.manager.EmployeePersonalInfoManagerImpl;
import com.epam.olukash.manager.ProjectManager;
import com.epam.olukash.manager.ProjectManagerImpl;
import com.epam.olukash.manager.UnitManager;
import com.epam.olukash.manager.UnitManagerImpl;
import com.sun.deploy.net.proxy.pac.PACFunctionsImpl;

/**
 * @author Oleksii.Lukash
 */
public class EntityWorker
{
	private static final Logger logger = Logger.getLogger(EntityWorker.class);

	public void run()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeManager employeeManager = context.getBean(EmployeeManagerImpl.class);
		ProjectManager projectManager =  context.getBean(ProjectManagerImpl.class);
		UnitManager unitManager = context.getBean(UnitManagerImpl.class);

		Employee employeeOleksii = createEmployee();
		Employee employeeXZ = createEmployee2();
		Long employeeOleksiiID = employeeManager.save(employeeOleksii);
		Long employeeXZID = employeeManager.save(employeeXZ);
		logger.info("Employee Oleksii saved with ID: " + employeeOleksiiID);
		logger.info("Employee XZ saved with ID: " + employeeXZID);

		Project project = createProject();
		Long projectID = projectManager.save(project);
		logger.info("Project CTrack saved with ID: " + projectID);

		Unit unit = createUnit();
		Long unitID = unitManager.save(unit);
		logger.info("Unit CTrack saved with ID: " + unitID);

		employeeManager.addToUnit(employeeOleksiiID, unitID);
		employeeManager.addToUnit(employeeXZID, unitID);
		logger.info("Employee with ID: " + employeeOleksiiID + " added to Unit with ID: " + unitID);
		logger.info("Employee with ID: " + employeeXZID + " added to Unit with ID: " + unitID);

        employeeManager.assignToProject(employeeOleksiiID, projectID);
		logger.info("Employee with ID: " + employeeOleksiiID + " assigned to Project with ID: " + projectID);

		//close resources
		context.close();
	}

	private Employee createEmployee()
	{
		Employee employee = new Employee();
		employee.setPosition("Midle Java Developer");
		employee.setEmployeeStatus(EmployeeStatus.NIIGER);
		Address address = new Address();
		address.setCity("Minsk");
		address.setStreet("R40");
		employee.setAddress(address);
		EmployeePersonalInfo info = new EmployeePersonalInfo();
		info.setEmployeeName("Oleksii");
		info.setAge(27);
		info.setEmployee(employee);
		employee.setPersonalInfo(info);
		return employee;
	}

	private Employee createEmployee2()
	{
		Employee employee = new Employee();
		employee.setPosition("Junior Java Developer");
		employee.setEmployeeStatus(EmployeeStatus.DONKEY);
		Address address = new Address();
		address.setCity("Minsk");
		address.setStreet("R40");
		employee.setAddress(address);
		EmployeePersonalInfo info = new EmployeePersonalInfo();
		info.setEmployeeName("XZ");
		info.setAge(20);
		info.setEmployee(employee);
		employee.setPersonalInfo(info);
		return employee;
	}

	private Project createProject()
	{
		Project project = new Project();
		project.setProjectName("CTrack");
		return project;
	}

	private Unit createUnit()
	{
		Unit unit = new Unit();
		unit.setUnitName("Thomson Reuters");
		return unit;
	}
}
