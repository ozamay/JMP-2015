package main.java.com.epam.olukash;

import main.java.com.epam.olukash.dbgenerator.DBGenerator;

/**
 * @author Oleksii.Lukash
 */
public class Main
{
	public static void main(String[] args)
	{
		DBGenerator dbGenerator = new DBGenerator();
		dbGenerator.run();
	}
}
