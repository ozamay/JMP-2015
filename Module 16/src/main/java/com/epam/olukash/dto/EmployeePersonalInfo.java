package com.epam.olukash.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Oleksii.Lukash
 */
@Entity
@Table(name="EmployeePersonalInfo")
public class EmployeePersonalInfo extends AbstractBean
{
	public static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employeeID", nullable=false)
	@SequenceGenerator(name = "empInfo_seq", sequenceName = "empInfo_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empInfo_seq")
	private long EmployeePersonalInfoID;

	@Column(name = "employeeName", nullable=false)
	private String employeeName;

	@Column(name = "age", nullable=false)
	private int age;


	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Employee employee;

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		EmployeePersonalInfo info = (EmployeePersonalInfo) o;

		if (EmployeePersonalInfoID != info.EmployeePersonalInfoID)
			return false;
		if (age != info.age)
			return false;
		if (employeeName != null ? !employeeName.equals(info.employeeName) : info.employeeName != null)
			return false;
		return employee != null ? employee.equals(info.employee) : info.employee == null;

	}

	@Override
	public int hashCode()
	{
		int result = (int) (EmployeePersonalInfoID ^ (EmployeePersonalInfoID >>> 32));
		result = 31 * result + (employeeName != null ? employeeName.hashCode() : 0);
		result = 31 * result + age;
		result = 31 * result + (employee != null ? employee.hashCode() : 0);
		return result;
	}

	@Override
	public String toString()
	{
		return "EmployeePersonalInfo{" +
				"EmployeePersonalInfoID=" + EmployeePersonalInfoID +
				", employeeName='" + employeeName + '\'' +
				", age=" + age +
				", employee=" + employee +
				'}';
	}

	public long getEmployeePersonalInfoID()
	{
		return EmployeePersonalInfoID;
	}

	public void setEmployeePersonalInfoID(long employeePersonalInfoID)
	{
		EmployeePersonalInfoID = employeePersonalInfoID;
	}

	public String getEmployeeName()
	{
		return employeeName;
	}

	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
}
