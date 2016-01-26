package com.epam.olukash.module7.testobj;

import java.util.HashMap;
import java.util.Map;

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
			Map<Double, Object> map = new HashMap<>();
			for (int j = 0; j < 20; j++)
			{
				Object[] object = new Object[100000];
				map.put(Math.random(), object);
			}
			map = null;
		}
	}
}
