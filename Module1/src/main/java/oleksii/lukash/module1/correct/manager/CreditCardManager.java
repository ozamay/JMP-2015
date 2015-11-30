package oleksii.lukash.module1.correct.manager;

import java.math.BigDecimal;
import java.util.List;

import oleksii.lukash.module1.correct.bean.CreditCard;

/**
 * Created by Oleksii_Lukash on 11/28/2015.
 */
public interface CreditCardManager extends AbstractManager<CreditCard>
{
	List<CreditCard> getVisaCreditCards();

	BigDecimal getAmountOfLastTransaction(Long creditCardID);
}
