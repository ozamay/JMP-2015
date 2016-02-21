package main.java.com.epam.olukash.dao.util;

import java.util.Date;

/**
 * @author Oleksii.Lukash
 */
public class DateUtil
{
	public static Date getRandomDate(Date startDate, Date endDate)
	{
		long offset = startDate.getTime();
		long end = endDate.getTime();
		long diff = end - offset + 1;
		return new Date(offset + (long)(Math.random() * diff));
	}
}
