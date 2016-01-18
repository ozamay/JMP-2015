package com.epam.olukash.module6.heap;

/**
 * @author Oleksii_Lukash
 * @date 1/18/2016
 */
public class TestObj
{
	private int x;

	public TestObj(int x)
	{
	 	this.x = x;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TestObj testObj = (TestObj) o;

		return x == testObj.x;

	}

	@Override
	public int hashCode()
	{
		return x;
	}
}
