package oleksii.lukash.module1.correct.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Oleksii_Lukash on 11/28/2015.
 */
public abstract class AbstractLoanAccount extends AbstractAccount
{
	private Date endDate;

	public void setCreditAmount(){};

	public void setMonthlyPayment(){};

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
