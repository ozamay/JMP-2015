package oleksii.lukash.module1.erroneous.manager;

import java.util.List;

import oleksii.lukash.module1.erroneous.bean.ErroneousCreditCard;
import oleksii.lukash.module1.erroneous.bean.ErroneousMortgage;
import oleksii.lukash.module1.erroneous.bean.ErroneousUser;

/**
 * Created by Oleksii_Lukash on 11/28/2015.
 */
public interface ErroneousAccountManager
{
	ErroneousCreditCard saveDepositAccount(ErroneousCreditCard depositAccount);

	ErroneousCreditCard updateDepositAccount(ErroneousCreditCard depositAccount);

	ErroneousMortgage saveOverdraftAccount(ErroneousMortgage overdraftAccount);

	ErroneousMortgage updateOverdraftAccount(ErroneousMortgage overdraftAccount);

	//Interface Segregation Principle - we can put this 2 methods in separate interface
	void updateUser(ErroneousUser user);

	List<ErroneousUser> getAllusers();
}
