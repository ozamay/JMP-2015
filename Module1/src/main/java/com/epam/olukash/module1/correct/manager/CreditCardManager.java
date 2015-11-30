package com.epam.olukash.module1.correct.manager;

import java.math.BigDecimal;
import java.util.List;

import com.epam.olukash.module1.correct.bean.CreditCard;

/**
 * @author Oleksii_Lukash
 * @date 11/28/2015
 */
public interface CreditCardManager extends AbstractManager<CreditCard>
{
	List<CreditCard> getVisaCreditCards();

	BigDecimal getAmountOfLastTransaction(Long creditCardID);
}
