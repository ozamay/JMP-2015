package oleksii.lukash.module1.runner;

import oleksii.lukash.module1.correct.bean.CreditCard;
import oleksii.lukash.module1.correct.bean.CurrencyEUR;
import oleksii.lukash.module1.correct.bean.CurrencyUSD;
import oleksii.lukash.module1.correct.bean.Mortgage;
import oleksii.lukash.module1.correct.bean.User;
import oleksii.lukash.module1.correct.manager.CreditCardManager;
import oleksii.lukash.module1.correct.manager.CreditCardManagerImpl;
import oleksii.lukash.module1.correct.manager.UserManager;
import oleksii.lukash.module1.correct.manager.UserManagerImpl;
import oleksii.lukash.module1.erroneous.bean.ErroneousCreditCard;
import oleksii.lukash.module1.erroneous.manager.ErroneousAccountManager;
import oleksii.lukash.module1.erroneous.manager.ErroneousAccountManagerImpl;

/**
 * Created by Oleksii_Lukash on 11/28/2015.
 */
public class Runner
{
	public static void main(String [ ] args)
	{
		// Dependency Inversion Principle
		// You see that ErroneousCreditCard(higher level component) depends on CurrencyUSD (lower level component).
		// we can't create ErroneousCreditCard with different currency
		ErroneousCreditCard erroneousCreditCard = new ErroneousCreditCard();

		// Correct uses of Dependency Inversion Principle
		CreditCard creditCard = new CreditCard(new CurrencyEUR());
		CreditCard creditCard1 = new CreditCard(new CurrencyUSD());

		///////////////////////////////////////////////////////////////////////////////////////////////////////////

		//Interface Segregation Principle
		//use one general interface for different logic
		ErroneousAccountManager erroneousAccountManager = new ErroneousAccountManagerImpl();

		erroneousAccountManager.saveDepositAccount(erroneousCreditCard);
		erroneousAccountManager.getAllusers();

		// Correct uses of Interface Segregation Principle
		CreditCardManager creditCardManager = new CreditCardManagerImpl();
		creditCardManager.getVisaCreditCards();

		UserManager userManager = new UserManagerImpl();
		userManager.remove(new User());

		///////////////////////////////////////////////////////////////////////////////////////////////////////////

		//Liskov Substitution Principle
		//We dont need this 3 method in CreditCard
		ErroneousCreditCard errCreditCard = new ErroneousCreditCard();
		errCreditCard.setCreditAmount();
		errCreditCard.setDebitAmount();
		errCreditCard.getMonthlyPayment();

		// Correct uses of Liskov Substitution Principle
		//Each of specific class has specific method
		CreditCard creditCard2 = new CreditCard(new CurrencyUSD());
		creditCard2.setDebitAmount();

		Mortgage mortgage = new Mortgage();
		mortgage.setMonthlyPayment();
		mortgage.setCreditAmount();

		///////////////////////////////////////////////////////////////////////////////////////////////////////////

		//Single responsibility principle
		//ErroneousMortgage entity has more then one responsibility. getAmountOfLastTransaction() method should be in other class
		ErroneousCreditCard errCreditCard2 = new ErroneousCreditCard();
		errCreditCard.getInterestRate();
		errCreditCard2.getAmountOfLastTransaction();

		// Correct uses of Single responsibility principle
		creditCardManager.getAmountOfLastTransaction(errCreditCard.getId());

		///////////////////////////////////////////////////////////////////////////////////////////////////////////

		////Open/Closed principle
		//checkSomeDataOnlyForDepositAccountClass() this method should be private
		ErroneousCreditCard errCreditCard3 = new ErroneousCreditCard();
		errCreditCard3.checkSomeDataOnlyForDepositAccountClass();
	}

}
