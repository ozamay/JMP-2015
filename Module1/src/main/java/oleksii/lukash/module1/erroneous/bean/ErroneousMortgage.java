package oleksii.lukash.module1.erroneous.bean;

import java.math.BigDecimal;

/**
 * Created by Oleksii_Lukash on 11/28/2015.
 */
public class ErroneousMortgage extends ErroneousAbsctractAccount
{
	private long interestRate;
	private BigDecimal creditBalance;

	//Single responsibility principle - we should put this method in other class
	//otherwise this class have more then one responsibility
	public String getSomeDataFromDB()
	{
		//return some data from database
		return null;
	}

	//////////////////////////////////////////////////////

	public long getInterestRate()
	{
		return interestRate;
	}

	public void setInterestRate(long interestRate)
	{
		this.interestRate = interestRate;
	}

	public BigDecimal getCreditBalance()
	{
		return creditBalance;
	}

	public void setCreditBalance(BigDecimal creditBalance)
	{
		this.creditBalance = creditBalance;
	}


}
