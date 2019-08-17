package com.ayofill.bankapp;

import com.ayofill.bankapp.model.Account;
import com.ayofill.bankapp.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author afilegbe
 */
class AccountServiceTest {
    private final AccountService accountService = new AccountService();

    @Test
    @DisplayName("Test Account Retrieval")
    void testGetAccount() {
        Account account = accountService.getAccountDetails("12345");
        assertNotNull(account);
        System.out.println("Account is not null");
        assertEquals("John Bill", account.getName(), "Account name doesn't match expected value");
        System.out.println("Account name equals");
        assertEquals("12345", account.getAccountNumber(), "Account number mismatch");
        System.out.println("Account number matches");
    }

    @Test
    @DisplayName("Test Account Deposit")
    void testDepositAccount() {
        Account account = accountService.getAccountDetails("12345");
        assertNotNull(account);
        Double amt = 5000.0;
        Double expectedBalance = account.getBalance() + amt;

        String response = accountService.deposit("12345", amt);
        assertEquals("Deposit complete", response, "Response from service mismatch");
        System.out.println("Account Deposit ok");

        //check if accountbalance was updated
        assertEquals(expectedBalance, account.getBalance(), "Account Balance not right");
        System.out.println("Account balance check ok");
    }
}
