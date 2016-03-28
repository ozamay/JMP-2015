package com.epam.olukash.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@SequenceGenerator(name = "proj_seq", sequenceName = "proj_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "proj_seq")
	private long projectID;

	@Column(nullable=false)
	private String projectName;

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
		return projectName != null ? projectName.equals(project.projectName) : project.projectName == null;

	}

	@Override
	public int hashCode()
	{
		int result = (int) (projectID ^ (projectID >>> 32));
		result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
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

}
