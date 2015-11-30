package oleksii.lukash.module1.erroneous.bean;

/**
 * Created by Oleksii_Lukash on 11/28/2015.
 */
public abstract class ErroneousAbsctractAccount
{
	protected long id;
	protected String accountName;
	protected long accountNumber;

	//Liskov Substitution Principle
	//we cant create child class ErroneousDepositAccount because we down need setCreditAmount() and  getMonthlyPayment() methods
	//we cant create child class ErroneousOverdraftAccount because we down need setDebitAmount() method
	public void setDebitAmount(){};
	public void setCreditAmount(){};
	public void getMonthlyPayment(){};

	//////////////////////////////////////////////////////

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public long getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber)
	{
		this.accountNumber = accountNumber;
	}
}
