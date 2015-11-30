package com.epam.olukash.module1.correct.bean;

/**
 * @author Oleksii_Lukash
 * @date 11/28/2015
 */
public abstract class AbstractCurrentAccount extends AbstractAccount
{
	private Long additionalRate;

	public void setDebitAmount()
	{
		throw new UnsupportedOperationException();
	}

	//////////////////////////////////////////////////////

	public Long getAdditionalRate()
	{
		return additionalRate;
	}

	public void setAdditionalRate(Long additionalRate)
	{
		this.additionalRate = additionalRate;
	}

}
