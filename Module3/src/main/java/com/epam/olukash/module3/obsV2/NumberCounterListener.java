package com.epam.olukash.module3.obsV2;

import org.apache.commons.lang.math.NumberUtils;

/**
 * @author Oleksii_Lukash
 * @date 12/16/2015
 */
public class NumberCounterListener implements ObserverV2
{
	private int numberCounter;

	@Override
	public void update(String currentWord)
	{
		updateNumberCounter(currentWord);
	}

	private void updateNumberCounter(String currentWord)
	{
		if(NumberUtils.isNumber(currentWord))
		{
			numberCounter++;
			System.out.println(this);
		}
	}

	@Override
	public String toString()
	{
		return "numberCounter: [" + numberCounter + "]";
	}
}
