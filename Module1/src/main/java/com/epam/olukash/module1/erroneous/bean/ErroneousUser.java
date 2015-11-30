package com.epam.olukash.module1.erroneous.bean;

/**
 * @author Oleksii_Lukash
 * @date 11/28/2015
 */
public class ErroneousUser
{
	private ErroneousMortgage overdraft;
	private String name;
	private String lastName;

	// Dependency Inversion Principle
	// You see that ErroneousUser (higher level component) depends on ErroneousOverdraftAccount (lower level component).
	// we can't create use with different account, for example with Overdraft
	public ErroneousUser()
	{
		overdraft = new ErroneousMortgage();
	}

	//////////////////////////////////////////////////////

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public ErroneousMortgage getOverdraft()
	{
		return overdraft;
	}

	public void setOverdraft(ErroneousMortgage overdraft)
	{
		this.overdraft = overdraft;
	}
}
