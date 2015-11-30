package oleksii.lukash.module1.correct.bean;

/**
 * Created by Oleksii_Lukash on 11/28/2015.
 */
public abstract class AbstractAccount extends AbstractBean
{
	private String accountName;
	private Long accountNumber;
	private Long interestRate;

	protected abstract long getAccountRate();

	//////////////////////////////////////////////////////

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public Long getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public Long getInterestRate()
	{
		return interestRate;
	}

	public void setInterestRate(Long interestRate)
	{
		this.interestRate = interestRate;
	}

}
