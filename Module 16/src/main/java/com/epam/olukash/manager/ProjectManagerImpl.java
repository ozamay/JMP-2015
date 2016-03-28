package com.epam.olukash.manager;

import org.springframework.stereotype.Component;

import com.epam.olukash.dao.ProjectDAO;
import com.epam.olukash.dto.Project;

/**
 * @author Oleksii.Lukash
 */
public class ProjectManagerImpl extends AbstractManager<Project, ProjectDAO> implements ProjectManager
{
	public void assigntToProject(long employeeID, long projectID)
	{

	}
}
