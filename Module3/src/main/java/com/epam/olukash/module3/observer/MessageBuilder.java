package com.epam.olukash.module3.observer;

/**
 * @author Oleksii_Lukash
 * @date 12/14/2015
 */
public class MessageBuilder
{
	private StringBuilder builder;

	public MessageBuilder()
	{
		this.builder = new StringBuilder();
	}

	public MessageBuilder(String observerName)
	{
		this.builder = new StringBuilder();
		builder.append(observerName);
		builder.append(" confirm: ");

	}

	public MessageBuilder appendTextInfo(TextInfo textInfo)
	{
		builder.append("wordCounter: [");
		builder.append(textInfo.getWordCounter());
		builder.append("], numberCounter: [");
		builder.append(textInfo.getNumberCounter());
		builder.append("], longestWord: [");
		builder.append(textInfo.getLongestWord());
		builder.append("]");
		return this;
	}

	public MessageBuilder appendTextInfo(WordInfo wordInfo)
	{
		builder.append("current word: [");
		builder.append(wordInfo.getCurrentWord());
		builder.append("], reverse word: [");
		builder.append(wordInfo.getReverseWord());
		builder.append("], ");
		return this;
	}

	public String build()
	{
		return builder.toString();
	}

	public void clear()
	{
		builder = new StringBuilder();
	}
}
