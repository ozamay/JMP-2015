package com.epam.olukash.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Oleksii.Lukash
 */
@Entity
@Table(name="Projects")
public class Project extends AbstractBean
{
	public static final long serialVersionUID = 1L;

	@Id
	@Column(name = "projectID", nullable=false)
	@SequenceGenerator(name = "proj_seq", sequenceName = "proj_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "proj_seq")
	private long projectID;

	@Column(name = "projectName", nullable=false)
	private String projectName;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "projects")
	private Set<Employee> employees;

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Project project = (Project) o;

		if (projectID != project.projectID)
			return false;
		if (projectName != null ? !projectName.equals(project.projectName) : project.projectName != null)
			return false;
		return employees != null ? employees.equals(project.employees) : project.employees == null;

	}

	@Override
	public int hashCode()
	{
		int result = (int) (projectID ^ (projectID >>> 32));
		result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
		result = 31 * result + (employees != null ? employees.hashCode() : 0);
		return result;
	}

	@Override
	public String toString()
	{
		return "Project{" +
				"projectID=" + projectID +
				", projectName='" + projectName + '\'' +
				'}';
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public long getProjectID()
	{
		return projectID;
	}

	public void setProjectID(long projectID)
	{
		this.projectID = projectID;
	}

	public Set<Employee> getEmployees()
	{
		return employees;
	}

	public void setEmployees(Set<Employee> employees)
	{
		this.employees = employees;
	}

}
