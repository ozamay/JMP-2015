package com.epam.olukash.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Oleksii.Lukash
 */
@Entity
@Table(name="Employee")
public class Employee extends AbstractBean
{
	public static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employeeID", nullable=false)
	@SequenceGenerator(name = "emp_seq", sequenceName = "emp_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "emp_seq")
	private long employeeID;

	@Column(name = "position", nullable=false)
	private String position;

	@Column(name = "employeeStatus", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EmployeeStatus employeeStatus;

	@Embedded
	private Address address;

	@OneToOne(cascade= CascadeType.ALL, mappedBy="employee")
	@PrimaryKeyJoinColumn
	private EmployeePersonalInfo personalInfo;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "employee_project", joinColumns = {
			@JoinColumn(name = "EMPLOYEEID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "PROJECTID",
					nullable = false, updatable = false) })
	private Set<Project> projects = new HashSet<>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unitID")
	private Unit unit;

	@Override
	public String toString()
	{
		return "Employee{" +
				"employeeID=" + employeeID +
				", position='" + position + '\'' +
				", employeeStatus=" + employeeStatus +
				'}';
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Employee employee = (Employee) o;

		if (employeeID != employee.employeeID)
			return false;
		if (position != null ? !position.equals(employee.position) : employee.position != null)
			return false;
		if (employeeStatus != employee.employeeStatus)
			return false;
		if (address != null ? !address.equals(employee.address) : employee.address != null)
			return false;
		if (personalInfo != null ? !personalInfo.equals(employee.personalInfo) : employee.personalInfo != null)
			return false;
		return unit != null ? unit.equals(employee.unit) : employee.unit == null;

	}

	@Override
	public int hashCode()
	{
		int result = (int) (employeeID ^ (employeeID >>> 32));
		result = 31 * result + (position != null ? position.hashCode() : 0);
		result = 31 * result + (employeeStatus != null ? employeeStatus.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (personalInfo != null ? personalInfo.hashCode() : 0);
		result = 31 * result + (unit != null ? unit.hashCode() : 0);
		return result;
	}

	public long getEmployeeID()
	{
		return employeeID;
	}

	public void setEmployeeID(long employeeID)
	{
		this.employeeID = employeeID;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public EmployeeStatus getEmployeeStatus()
	{
		return employeeStatus;
	}

	public void setEmployeeStatus(EmployeeStatus employeeStatus)
	{
		this.employeeStatus = employeeStatus;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public EmployeePersonalInfo getPersonalInfo()
	{
		return personalInfo;
	}

	public void setPersonalInfo(EmployeePersonalInfo personalInfo)
	{
		this.personalInfo = personalInfo;
	}

	public Set<Project> getProjects()
	{
		return projects;
	}

	public void setProjects(Set<Project> projects)
	{
		this.projects = projects;
	}

	public Unit getUnit()
	{
		return unit;
	}

	public void setUnit(Unit unit)
	{
		this.unit = unit;
	}

}
