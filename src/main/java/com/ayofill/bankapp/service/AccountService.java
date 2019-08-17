package com.ayofill.bankapp.service;

import com.ayofill.bankapp.model.Account;
import com.ayofill.bankapp.model.Transaction;
import com.ayofill.bankapp.util.Util;

/**
 * Facade to interface with account database and processing
 *
 * @author afilegbe
 */
public class AccountService {
    /**
     * This method will be used to add new account to the database #Util.accounts
     * Validation should be in place to ensure basic details of an account is added
     * <p>
     * This include;
     * 1. Name
     * 2. AccountBalance greater than 0
     * 3. Account Number
     * 4. Account is active
     *
     * @param account new account to be added to the database.
     */
    public String addAccount(Account account) {
        throw new IllegalArgumentException("Not implemented");
    }

    /**
     * When an account holder closes his/her account, the account
     * should be removed from active accounts database and added to the
     * archived accounts database #Util.archivedAccount
     *
     * @param accountNumber of account to be deleted.
     */
    public void delete(String accountNumber) {
        throw new IllegalArgumentException("Not implemented");
    }

    /**
     * Search throw the database to check if account whose number was provided is present.
     * <p>
     * If details not found in active account db, check archived account otherwise throw exception that account was not found
     *
     * @param accountNumber to retrieve
     * @return Account was detail was provided
     */
    public Account getAccountDetails(String accountNumber) {
        //This is a naive implementation. Ensure all mentioned in note above is done
        return Util.accounts.get(accountNumber);
    }

    /**
     * Transfer funds from account from to account to.
     * <p>
     * The following validation should be done
     * 1. Check if amount is valid
     * 2. check if fromAccount is valid
     * 3. Check if amount exceeds fromAccount balance
     * 4. Check if to account exist
     * 5. Check if transaction limit has been passed
     * 6. log transaction details (create new database for transaction, new class to hold transaction details)
     *
     * @param fromAccountNumber account to transfer from
     * @param toAccountNumber   account to transfer to
     * @param amount            transaction amount
     * @return details of transfer
     */
    public String transfer(String fromAccountNumber, String toAccountNumber, Double amount) {
        throw new IllegalArgumentException("Not implemented");
    }

    /**
     * Transfer funds from account from to account to.
     * <p>
     * The following validation should be done
     * 1. Check if amount is valid
     * 2. check if payerAccountNumber is valid
     * 3. Check if amount exceeds payerAccountNumber balance
     * 4. Check if payeeAccountNumber exist
     * 5. log transaction details (create new database for transaction, new class to hold transaction details)
     *
     * @param payerAccountNumber account to pay from
     * @param payeeAccountNumber account to pay to
     * @param amount             transaction amount
     * @return details of payment
     */
    public String payBill(String payerAccountNumber, String payeeAccountNumber, Double amount) {
        throw new IllegalArgumentException("Not implemented");
    }

    /**
     * Deposit money into an account
     * <p>
     * 1. Ensure amount is valid
     * 2. Ensure account number is valid
     * 3. Update account if 1 and 2 is success
     * 4. Log transaction
     *
     * @param accountNumber details of account to deposit to
     * @param amount        transaction amount
     * @return deposit details
     */
    public String deposit(String accountNumber, Double amount) {
        //Check if amount is valid
        if (amount <= 0) return "Invalid amount";
        //Ensure account number is valid
        Account account = Util.accounts.remove(accountNumber);
        if (account == null) return "Invalid Account Number";
        //Compute new balance
        Double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        //Log Transaction
        Util.transactions.get(Util.DEPOSIT).add(new Transaction(accountNumber, null, amount));
        //Update account
        Util.accounts.put(accountNumber, account);
        return "Deposit complete";
    }
}
