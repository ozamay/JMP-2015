package com.epam.olukash.module3.observer;

import org.apache.commons.lang.StringUtils;

/**
 * @author Oleksii_Lukash
 * @date 12/14/2015
 */
public class WordInfo
{
	private final String currentWord;

	public WordInfo(String word)
	{
		this.currentWord = word;
	}

	public String getReverseWord()
	{
		return StringUtils.reverse(currentWord);
	}

	public String getCurrentWord()
	{
		return currentWord;
	}
}
