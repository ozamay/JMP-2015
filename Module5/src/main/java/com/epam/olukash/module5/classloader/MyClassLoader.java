package com.epam.olukash.module5.classloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	protected Class<?> findClass(String name) throws ClassNotFoundException
	{
		String classPath = !pathToClass.contains(".class") ? (pathToClass + ".class") : pathToClass;
		Path path = Paths.get(classPath);
		byte[] classData = null;
		try
		{
			classData = Files.readAllBytes(path);
		}
		catch (IOException e)
		{
			logger.error("Status: error. Class with name [" + name + "] not found. " + e);
		}
		return defineClass(name, classData, 0, classData.length);
	}
}
