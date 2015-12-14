package com.epam.olukash.module3.observer;

/**
 * @author Oleksii_Lukash
 * @date 12/14/2015
 */
public class TextInfo
{
	private int wordCounter;
	private int numberCounter;
	private String longestWord;

	public int getWordCounter()
	{
		return wordCounter;
	}

	public void setWordCounter(int wordCounter)
	{
		this.wordCounter = wordCounter;
	}

	public int getNumberCounter()
	{
		return numberCounter;
	}

	public void setNumberCounter(int numberCounter)
	{
		this.numberCounter = numberCounter;
	}

	public String getLongestWord()
	{
		return longestWord;
	}

	public void setLongestWord(String longestWord)
	{
		this.longestWord = longestWord;
	}
}
