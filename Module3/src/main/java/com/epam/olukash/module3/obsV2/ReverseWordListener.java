package com.epam.olukash.module3.obsV2;

import org.apache.commons.lang.StringUtils;

import com.epam.olukash.module3.obsV2.ObserverV2;

/**
 * @author Oleksii_Lukash
 * @date 12/16/2015
 */
public class ReverseWordListener implements ObserverV2
{
	private String reverseWord;

	@Override
	public void update(String currentWord)
	{
		reverseWord = StringUtils.reverse(currentWord);
		System.out.println(this);
	}

	@Override
	public String toString()
	{
		return "reverse word: [" + reverseWord + "]";
	}
}
