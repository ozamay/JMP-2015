package com.epam.olukash.module3.obsV2;


/**
 * @author Oleksii_Lukash
 * @date 12/16/2015
 */
public class LongestWordKeeperListener implements ObserverV2
{
	private String longestWord;

	@Override
	public void update(String currentWord)
	{
		updateLongestWord(currentWord);
	}

	private void updateLongestWord(String currentWord)
	{
		if(longestWord == null || currentWord.length() >= longestWord.length())
		{
			longestWord = currentWord;
			System.out.println(this);
		}
	}

	@Override
	public String toString()
	{
		return "longestWord: [" + longestWord + "]";
	}
}
