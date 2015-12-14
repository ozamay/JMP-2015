package com.epam.olukash.module3.observer;

/**
 * @author Oleksii_Lukash
 * @date 12/14/2015
 */
public class WordInfo
{
	private String currentWord;
	private String reverseWord;

	public WordInfo(String word)
	{
		this.currentWord = word;
	}

	public String getReverseWord()
	{
		return currentWord != null ? new StringBuilder(currentWord).reverse().toString() : null;
	}

	public String getCurrentWord()
	{
		return currentWord;
	}
}
