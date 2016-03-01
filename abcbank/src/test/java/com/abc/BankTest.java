package com.abc;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

import junit.framework.AssertionFailedError;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;
    private Bank bank;

    @Test
    public void customerSummary() {
        Account checkingAccount = new Account(Account.SAVINGS);
        stubForCheckingAccount(checkingAccount);
        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void checkingAccount() {
        Account checkingAccount = new Account(Account.SAVINGS);
        stubForCheckingAccount(checkingAccount);
        checkingAccount.deposit(100.0);
        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void savings_account() {
        Account checkingAccount = new Account(Account.SAVINGS);
        stubForCheckingAccount(checkingAccount);
        checkingAccount.deposit(1500.0);

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void maxi_savings_account() {
        Account checkingAccount = new Account(Account.MAXI_SAVINGS);
        stubForCheckingAccount(checkingAccount);

        checkingAccount.deposit(3000.0);

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test(expected = AssertionFailedError.class)
    public void testGetFirstCustomer()
    {
        Bank bank = new Bank();
        fail(bank.getFirstCustomer());
    }

    private void stubForCheckingAccount(Account account)
    {
        bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(account);
        bank.addCustomer(john);
    }

}
