package com.epam.olukash.manager;

import com.epam.olukash.dto.Project;

/**
 * @author Oleksii.Lukash
 */
public interface ProjectManager extends BeanManager<Project>
{
 	void assigntToProject(long employeeID, long projectID);
}
