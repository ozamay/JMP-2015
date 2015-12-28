package com.epam.olukash.module5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.epam.olukash.module5.classloader.CannotLoadClassException;
import com.epam.olukash.module5.classloader.MyClassLoader;

/**
 * @author Oleksii_Lukash
 * @date 12/26/2015
 */
public class MainExample
{
	private static final Logger logger = Logger.getLogger(MainExample.class);
	private static final String CLASS_NAME = "Semaphore";
	private static final String METHOD_NAME = "lever";

	public MainExample()
	{
		init();
	}

	private void init()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter class path: ");
		while (scanner.hasNext())
		{
			String classPath = scanner.nextLine();
			if (classPath != null && !classPath.isEmpty() &&
					(StringUtils.endsWithAny(classPath, "Semaphore.class", "Semaphore")))
			{
				load(classPath);
			}
			else
			{
				logger.info("Class path is not correct.");
			}
			System.out.println("One more: ");
		}
	}

	private void load(String classPath)
	{
		try
		{
			MyClassLoader myClassLoader = new MyClassLoader(classPath);
			logger.info("Status: in progress. Loading Class '" + classPath + "'");
			Class myClass = myClassLoader.loadClass(CLASS_NAME);

			if(myClass != null)
			{
				logger.info("Status: success. Class with name [" + myClass.getName() + "] loaded.");
				Constructor constructor = myClass.getConstructor();
				Object myClassObject = constructor.newInstance();

				Method leverMethod = myClass.getMethod(METHOD_NAME);
				leverMethod.invoke(myClassObject);
			}
		}
		catch (Exception e)
		{
			logger.error("Status: error. " + e);
		}
	}
}
