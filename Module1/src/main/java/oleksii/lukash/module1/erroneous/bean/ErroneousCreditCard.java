package oleksii.lukash.module1.erroneous.bean;

import java.math.BigDecimal;

/**
 * Created by Oleksii_Lukash on 11/28/2015.
 */
public class ErroneousCreditCard extends ErroneousAbsctractAccount
{
	private long interestRate;
	private BigDecimal debitBalance;
	protected ErroneousCurrencyUSD currencyUSD;

	// Dependency Inversion Principle
	// You see that ErroneousCreditCard(higher level component) depends on CurrencyUSD (lower level component).
	// we can't create ErroneousCreditCard with different currency
	public ErroneousCreditCard()
	{
		currencyUSD = new ErroneousCurrencyUSD();
	}

   	//Single responsibility principle - we should put this method in other class
	//otherwise this class have more then one responsibility
	public BigDecimal getAmountOfLastTransaction()
	{
		//return some data from database
		return null;
	}

	//Open/Closed principle
	//This method should be private because we use it only for ErroneousDepositAccount class
	public boolean checkSomeDataOnlyForDepositAccountClass()
	{
		return true;

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

	public BigDecimal getDebitBalance()
	{
		return debitBalance;
	}

	public void setDebitBalance(BigDecimal debitBalance)
	{
		this.debitBalance = debitBalance;
	}


}
