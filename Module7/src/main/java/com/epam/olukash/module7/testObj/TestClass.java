package com.epam.olukash.module7.testobj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleksii_Lukash
 * @date 1/23/2016
 */
public class TestClass
{
	public void objectGenerator()
	{
		for (int i = 0; ; i++)
		{
			List<Double> list = new ArrayList<>();
			for (int j = 0; j < 20; j++)
			{
				list.add(Math.random());
			}
			list = null;
		}
	}
}
