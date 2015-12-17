package com.epam.olukash.module3.obsV2;


/**
 * @author Oleksii_Lukash
 * @date 12/16/2015
 */
public class WordCounterListener implements ObserverV2
{
	private int wordCounter;

	@Override
	public void update(String currentWord)
	{
		updateWordCounter();
	}

	private void updateWordCounter()
	{
		wordCounter++;
		System.out.println(this);
	}

	@Override
	public String toString()
	{
		return "wordCounterListener[" + wordCounter + "]";
	}
}
