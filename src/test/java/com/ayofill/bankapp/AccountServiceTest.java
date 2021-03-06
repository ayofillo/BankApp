package com.ayofill.bankapp;

import com.ayofill.bankapp.model.Account;
import com.ayofill.bankapp.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author afilegbe
 */
class AccountServiceTest {
    private final AccountService accountService = new AccountService();

    @Test //annotations
    @DisplayName("Test Account Retrieval")
    void testGetAccount() {
        Account account = accountService.getAccountDetails("12345");
        //check if account returned is not null
        assertNotNull(account);
        System.out.println("Account is not null");
        assertEquals("John Bill", account.getName(), "Account name doesn't match expected value");
        System.out.println("Account name equals");
        assertEquals("12345", account.getAccountNumber(), "Account number mismatch");
        System.out.println("Account number matches");

        assertNotEquals(new Double(5430000.0), account.getBalance(), "Account balance mismatch");
        System.out.println("Account balance matches");
    }

    @Test
    @DisplayName("Test Account Retrieval Invalid Account Number")
        //Negative scenario
    void testGetInvalidAccount() {
        Account account = accountService.getAccountDetails("12345fdsdas");
        assertNull(account);
    }

    @Test
    @DisplayName("Test Account Deposit")
    void testDepositAccount() {
        Account account = accountService.getAccountDetails("12345");
        assertNotNull(account);

        //compute new balance after deposit
        Double amt = 400.0;
        Double expectedBalance = account.getBalance() + amt;

        //invoke deposit operation
        String response = accountService.deposit("12345", amt);
        assertEquals("Deposit complete", response, "Response from service mismatch");
        System.out.println("Account Deposit ok");

        //check if accountbalance was updated
        assertEquals(expectedBalance, account.getBalance(), "Account Balance not right");
        System.out.println("Account balance check ok");
    }

    @Test
    @DisplayName("Test Deposit Account Invalid Amount")
    void testingDepositAccountInvalidAmount() {
        String response = accountService.deposit("12345", -400.0);
        assertEquals("Invalid amount", response);
        System.out.println("Amount passed is not valid");
    }

    @Test
    @DisplayName("Test Deposit Account Invalid Account")
    void testingDepositAccountInvalidAccount() {
        String response = accountService.deposit("12345aq", 400.0);
        assertEquals("Invalid Account Number", response);
        System.out.println("Account number is not valid");
    }
}
