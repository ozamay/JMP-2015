package com.epam.olukash.module1.correct.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Oleksii_Lukash
 * @date 11/28/2015
 */
public abstract class AbstractLoanAccount extends AbstractAccount
{
	private Date endDate;

	public void setCreditAmount()
	{
		throw new UnsupportedOperationException();
	}

	public void setMonthlyPayment()
	{
		throw new UnsupportedOperationException();
	}

	//////////////////////////////////////////////////////

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

}
