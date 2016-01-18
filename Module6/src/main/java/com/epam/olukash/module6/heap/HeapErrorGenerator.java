package com.epam.olukash.module6.heap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleksii_Lukash
 * @date 1/18/2016
 */
public class HeapErrorGenerator
{
	public HeapErrorGenerator()
	{
		generate();
	}

	private void generate()
	{
		Map<TestObj, String> map = new HashMap<>();

		for(int i = 0; i < 100000; i++)
		{
			TestObj obj = new TestObj(i);
			map.put(obj, "Number " + i);
			System.out.println(i);
		}
	}
}
