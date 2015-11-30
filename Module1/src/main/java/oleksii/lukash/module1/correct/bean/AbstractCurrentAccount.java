package oleksii.lukash.module1.correct.bean;

/**
 * Created by Oleksii_Lukash on 11/28/2015.
 */
public abstract class AbstractCurrentAccount extends AbstractAccount
{
	private Long additionalRate;

	public void setDebitAmount(){}

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
