package com.epam.olukash.module6.permgen;


import javassist.CannotCompileException;
import javassist.ClassPool;

/**
 * @author Oleksii_Lukash
 * @date 1/18/2016
 */
public class PermGenErrorGenerator
{
	public PermGenErrorGenerator()
	{
		init();
	}

	private void init()
	{
		try
		{
			generate();
		}
		catch (OutOfMemoryError r)
		{
			System.err.println(r.toString());
		}

	}

	private void generate()
	{
		for (int i = 0; i < 1000000; i++) {
			ClassPool pool = ClassPool.getDefault();

			try
			{
				pool.makeClass("com.epam.olukash.module6.permgen.TestObj" + i).toClass();
				System.out.println(i);
			}
			catch (CannotCompileException e)
			{
				e.printStackTrace();
			}
		}
	}
}
