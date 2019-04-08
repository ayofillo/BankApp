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
    private AccountService accountService = new AccountService();

    @Test
    @DisplayName("Test Account retrieval")
    void testGetAccount() {
        Account account = accountService.getAccountDetails("12345");
        assertNotNull(account);
        System.out.println("Account is not null");
        assertEquals(account.getName(), "John Bill", "Account name doesn't match expected value");
        System.out.println("Account name equals");
        assertEquals(account.getAccountNumber(), "12345", "Account number mismatch");
        System.out.println("Account number matches");
    }

}
