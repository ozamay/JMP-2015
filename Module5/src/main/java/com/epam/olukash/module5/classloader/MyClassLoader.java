package com.epam.olukash.module5.classloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author Oleksii_Lukash
 * @date 12/26/2015
 */
public class MyClassLoader extends ClassLoader
{
	private static final Logger logger = Logger.getLogger(MyClassLoader.class);
	private String pathToClass;

	public MyClassLoader(String classPath)
	{
		super(MyClassLoader.class.getClassLoader());
		this.pathToClass = classPath;
	}

	@Override
	public Class<?> loadClass(String name)
	{
		return findDefineClass(name);
	}

	public Class<?> findDefineClass(String name)
	{
		try
		{
			byte[] bytes = loadClassData();
			return defineClass(name, bytes, 0, bytes.length);
		}
		catch (CannotLoadClassException ex)
		{
			try
			{
				return super.loadClass(name);
			}
			catch (ClassNotFoundException e)
			{
				logger.error("Status: error. Class with name [" + name + "] not found. " + e);
			}
		}
		return null;
	}

	private byte[] loadClassData()
	{
		String classPath = !pathToClass.contains(".class") ? (pathToClass + ".class") : pathToClass;
		Path path = Paths.get(classPath);
		byte[] classData;
		try {
			classData = Files.readAllBytes(path);
			pathToClass = StringUtils.EMPTY;
		} catch (IOException e) {
			throw new CannotLoadClassException();
		}
		return classData;
	}

}
