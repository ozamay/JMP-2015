package com.epam.olukash.module5.classloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * @author Oleksii_Lukash
 * @date 12/26/2015
 */
public class MyClassLoader extends ClassLoader
{
	static Logger logger = Logger.getLogger(MyClassLoader.class.getName());

	public MyClassLoader()
	{
		super(MyClassLoader.class.getClassLoader());
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
			byte[] bytes = loadClassData(name);

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

	private byte[] loadClassData(String className)
	{
		File f = new File("target/classes/" + className.replaceAll("\\.", "/") + ".class");
		int size = (int) f.length();
		byte buff[] = new byte[size];
		try(DataInputStream dis = new DataInputStream(new FileInputStream(f)))
		{
			dis.readFully(buff);
		}
		catch (IOException e)
		{
			throw new CannotLoadClassException();
		}
		return buff;
	}

}
