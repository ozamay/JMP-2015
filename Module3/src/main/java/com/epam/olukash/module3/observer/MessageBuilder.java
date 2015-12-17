package com.epam.olukash.module3.observer;

import org.apache.commons.lang.StringUtils;

/**
 * @author Oleksii_Lukash
 * @date 12/14/2015
 */
public class MessageBuilder
{
	private StringBuilder builder;
   	private String userName;

	public MessageBuilder(String userName)
	{
		this.userName = userName;
		this.builder = new StringBuilder();
	}

	public MessageBuilder()
	{
		this.builder = new StringBuilder();
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
		StringBuilder sb = new StringBuilder();
		sb.append(userName);
		sb.append(" confirm: ");
		return sb.append(builder.toString()).toString();
	}

	public MessageBuilder appendOberver(String observerName)
	{
		builder.append(observerName);
		builder.append(" confirm: ");
		return this;
	}
	public void clear()
	{
		builder = new StringBuilder();
	}
}
