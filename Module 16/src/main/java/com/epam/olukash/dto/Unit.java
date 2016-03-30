package com.epam.olukash.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Oleksii.Lukash
 */
@Entity
@Table(name="Unit")
public class Unit extends AbstractBean
{
	@Id
	@Column(name = "unitID", nullable=false)
	@SequenceGenerator(name = "unit_seq", sequenceName = "unit_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "unit_seq")
	private long unitID;

	@Column(name = "unitName", nullable=false)
	private String unitName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "unit")
	private List<Employee> employees;

	@Override
	public String toString()
	{
		return "Unit{" +
				"unitID=" + unitID +
				", unitName='" + unitName + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Unit unit = (Unit) o;

		if (unitID != unit.unitID)
			return false;
		if (unitName != null ? !unitName.equals(unit.unitName) : unit.unitName != null)
			return false;
		return employees != null ? employees.equals(unit.employees) : unit.employees == null;

	}

	@Override
	public int hashCode()
	{
		int result = (int) (unitID ^ (unitID >>> 32));
		result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
		result = 31 * result + (employees != null ? employees.hashCode() : 0);
		return result;
	}

	public long getUnitID()
	{
		return unitID;
	}

	public void setUnitID(long unitID)
	{
		this.unitID = unitID;
	}

	public String getUnitName()
	{
		return unitName;
	}

	public void setUnitName(String unitName)
	{
		this.unitName = unitName;
	}

	public List<Employee> getEmployees()
	{
		return employees;
	}

	public void setEmployees(List<Employee> employees)
	{
		this.employees = employees;
	}

}
