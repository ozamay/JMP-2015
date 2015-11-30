package com.epam.olukash.module1.erroneous.manager;

import java.util.List;

import com.epam.olukash.module1.erroneous.bean.ErroneousCreditCard;
import com.epam.olukash.module1.erroneous.bean.ErroneousMortgage;
import com.epam.olukash.module1.erroneous.bean.ErroneousUser;

/**
 * @author Oleksii_Lukash
 * @date 11/28/2015
 */
public interface ErroneousAccountManager
{
	ErroneousCreditCard saveDepositAccount(ErroneousCreditCard depositAccount);

	ErroneousCreditCard updateDepositAccount(ErroneousCreditCard depositAccount);

	ErroneousMortgage saveOverdraftAccount(ErroneousMortgage overdraftAccount);

	ErroneousMortgage updateOverdraftAccount(ErroneousMortgage overdraftAccount);

	//Interface Segregation Principle - we can put this 2 methods in separate interface
	void updateUser(ErroneousUser user);

	List<ErroneousUser> getAllUsers();
}
