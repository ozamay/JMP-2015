package main.java.com.epam.olukash.dao.util;

import java.sql.Timestamp;

/**
 * @author Oleksii.Lukash
 */
public class DateUtil
{
	public static Timestamp getRandomDate(String startDate, String endDate)
	{
		long offset = Timestamp.valueOf(startDate).getTime();
		long end = Timestamp.valueOf(endDate).getTime();
		long diff = end - offset + 1;
		Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
		return rand;
	}
}
