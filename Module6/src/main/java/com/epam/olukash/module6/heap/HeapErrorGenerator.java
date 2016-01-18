package com.epam.olukash.module6.heap;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

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
		while (true)
		{
			for(int i = 0; i < 1000000000; i++)
			{
				TestObj obj = new TestObj(i);
				map.put(obj, "Number " + i);
				System.out.println(i);
			}
		}
	}
}
