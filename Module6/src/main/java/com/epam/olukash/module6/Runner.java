package com.epam.olukash.module6;

import com.epam.olukash.module6.heap.HeapErrorGenerator;
import com.epam.olukash.module6.permgen.PermGenErrorGenerator;

/**
 * @author Oleksii_Lukash
 * @date 1/18/2016
 */
public class Runner
{
	public static void main(String args[])
	{
		new HeapErrorGenerator();

		//new PermGenErrorGenerator();
	}

}
