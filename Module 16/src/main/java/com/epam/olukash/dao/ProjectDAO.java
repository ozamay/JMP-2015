package com.epam.olukash.dao;

import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.Project;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class ProjectDAO extends AbstractDAO<Project>
{
	protected Class<? extends AbstractBean> getClazz()
	{
		return Project.class;
	}
}
