package com.epam.olukash.module1.correct.bean;

/**
 * @author Oleksii_Lukash
 * @date 11/28/2015
 */
public class CreditCard extends AbstractCurrentAccount
{
	private Currency currency;

	public CreditCard(Currency currency)
	{
		this.currency  = currency;
	}

	@Override
	protected long getAccountRate()
	{
		return 0;
	}

	public Currency getCurrency()
	{
		return currency;
	}
}
