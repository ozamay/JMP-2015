package oleksii.lukash.module1.correct.bean;

/**
 * Created by Oleksii_Lukash on 11/28/2015.
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
}
