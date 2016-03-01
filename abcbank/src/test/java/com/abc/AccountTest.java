package com.abc;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Oleksii.Lukash
 */
@RunWith(value = Parameterized.class)
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

	private int accountID;
	private double ammount;
	private double interestEarned;

	public AccountTest(int accountID, double ammount, double interestEarned)
	{
		this.accountID = accountID;
		this.ammount = ammount;
		this.interestEarned = interestEarned;
	}

	////////////////// Test interestEarned

	@Parameterized.Parameters
	public static Iterable<Object[]> data1() {
		return Arrays.asList(new Object[][] {
				{ 0, DEFAULT_AMOUNT, DEFAULT_AMOUNT*CHECKING_INTERESTRATE },
				{ 1, DEFAULT_AMOUNT, DEFAULT_AMOUNT*SAVINGS_INTERESTRATE },
				{ 1, AMOUNT_2000, 1+(AMOUNT_2000 - 1000)*SAVINGS_INTERESTRATE_GREATER },
				{ 2, DEFAULT_AMOUNT, DEFAULT_AMOUNT*MAXI_SAVINGS_INTERESTRATE },
				{ 2, AMOUNT_2000, 20+(AMOUNT_2000 - 1000)*MAXI_SAVINGS_INTERESTRATE_GREATER_1000},
				{ 2, AMOUNT_2001, 70+(AMOUNT_2001 - 2000)*MAXI_SAVINGS_INTERESTRATE_GREATER_2000}
		});
	}

	@Test
	public void testInterestEarned()
	{
		Account account = new Account(accountID);
		account.deposit(ammount);
		assertEquals(interestEarned, account.interestEarned());
	}

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