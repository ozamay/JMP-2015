package com.abc;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Oleksii.Lukash
 */
public class AccountTest
{
	public static final double CHECKING_INTERESTRATE = 0.001;
	public static final double SAVINGS_INTERESTRATE = 0.001;
	public static final double SAVINGS_INTERESTRATE_GREATER = 0.002;
	public static final double MAXI_SAVINGS_INTERESTRATE = 0.02;
	public static final double MAXI_SAVINGS_INTERESTRATE_GREATER_1000 = 0.05;
	public static final double MAXI_SAVINGS_INTERESTRATE_GREATER_2000 = 0.1;
	public static final double DEFAULT_AMOUNT = 1000;
	public static final double AMOUNT_2000 = 2000;
	public static final double AMOUNT_2001 = 2001;

	////////////////// Test deposit


	@Test
	public void testDeposit()
	{
		Account account = new Account(Account.CHECKING);
		account.deposit(DEFAULT_AMOUNT);
		assertTrue(!account.transactions.isEmpty());
		assertEquals(account.transactions.size(), 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeposit_throwException_depositIsZero()
	{
		Account account = new Account(Account.CHECKING);
		account.deposit(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeposit_throwException_depositIsNegative()
	{
		Account account = new Account(Account.CHECKING);
		account.deposit(-1);
	}

	////////////////// Test withdraw

	@Test
	public void testWithdraw()
	{
		Account account = new Account(Account.CHECKING);
		account.withdraw(DEFAULT_AMOUNT);
		assertTrue(!account.transactions.isEmpty());
		assertEquals(account.transactions.size(), 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWithdraw_throwException_depositIsZero()
	{
		Account account = new Account(Account.CHECKING);
		account.withdraw(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWithdraw_throwException_depositIsNegative()
	{
		Account account = new Account(Account.CHECKING);
		account.withdraw(-1);
	}

	////////////////// Test interestEarned

	@Test
	public void testInterestEarned_checkingAccount()
	{
		Account account = new Account(Account.CHECKING);
		double interestEarned = account.interestEarned();
		assertEquals(interestEarned, 0.0);
	}

	@Test
	public void testInterestEarned_checkingAccountWithoutAmount()
	{
		Account account = new Account(Account.CHECKING);
		account.deposit(DEFAULT_AMOUNT);
		double interestEarned = account.interestEarned();
		assertEquals(interestEarned, DEFAULT_AMOUNT*CHECKING_INTERESTRATE);
	}

	@Test
	public void testInterestEarned_savingAccount()
	{
		Account account = new Account(Account.SAVINGS);
		account.deposit(DEFAULT_AMOUNT);
		double interestEarned = account.interestEarned();
		assertEquals(interestEarned, DEFAULT_AMOUNT*SAVINGS_INTERESTRATE);
	}

	@Test
	public void testInterestEarned_savingAccountAmountMoreThen1000()
	{
		Account account = new Account(Account.SAVINGS);
		account.deposit(AMOUNT_2000);
		double interestEarned = account.interestEarned();
		assertEquals(interestEarned, 1+(AMOUNT_2000 - 1000)*SAVINGS_INTERESTRATE_GREATER);
	}

	@Test
	public void testInterestEarned__savingAccountWithoutAmount()
	{
		Account account = new Account(Account.SAVINGS);
		double interestEarned = account.interestEarned();
		assertEquals(interestEarned, 0.0);
	}

	@Test
	public void testInterestEarned_maxisavingAccount()
	{
		Account account = new Account(Account.MAXI_SAVINGS);
		account.deposit(DEFAULT_AMOUNT);
		double interestEarned = account.interestEarned();
		assertEquals(interestEarned, DEFAULT_AMOUNT*MAXI_SAVINGS_INTERESTRATE);
	}

	@Test
	public void testInterestEarned_maxisavingAccountAmountMoreThen1000()
	{
		Account account = new Account(Account.MAXI_SAVINGS);
		account.deposit(AMOUNT_2000);
		double interestEarned = account.interestEarned();
		assertEquals(interestEarned, 20+(AMOUNT_2000 - 1000)*MAXI_SAVINGS_INTERESTRATE_GREATER_1000);
	}

	@Test
	public void testInterestEarned_maxisavingAccountAmountMoreThen2000()
	{
		Account account = new Account(Account.MAXI_SAVINGS);
		account.deposit(AMOUNT_2001);
		double interestEarned = account.interestEarned();
		assertEquals(interestEarned, 70+(AMOUNT_2001 - 2000)*MAXI_SAVINGS_INTERESTRATE_GREATER_2000);
	}

	@Test
	public void testInterestEarned__maxisavingAccountWithoutAmount()
	{
		Account account = new Account(Account.MAXI_SAVINGS);
		double interestEarned = account.interestEarned();
		assertEquals(interestEarned, 0.0);
	}

	////////////////// Test sumTransactions

	@Test
	public void testSumTransactions()
	{
		Account account = new Account(Account.MAXI_SAVINGS);
		account.deposit(AMOUNT_2001);
		account.deposit(AMOUNT_2000);

		assertEquals(account.sumTransactions(), 4001.0);
	}

}