package com.ayofill.bankapp.util;

import com.ayofill.bankapp.model.Account;
import com.ayofill.bankapp.model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author afilegbe
 */
public class Util {
    //database for active accounts
    public static Map<String, Account> accounts = new HashMap<>();
    //database for non-active/closed accounts
    public static Map<String, Account> archivedAccount = new HashMap<>();
    //database for all transactions conducted on platform
    public static Map<String, List<Transaction>> transactions = new HashMap<>();

    //identifiers for transaction types
    public static final String TRANSFER = "Transfer";
    public static final String BILL_PAY = "BillPay";
    public static final String DEPOSIT = "Deposit";
    public static final String CLOSE = "Close";


    static {
        //Initialize with dummy accounts
        accounts.put("12345", new Account("12345", "John Bill", 600.0, true));
        accounts.put("775866", new Account("775866", "Amazon Bezos", 59800000.0, true));
        accounts.put("135856", new Account("135856", "Facebook Mark", 9150000.0, true));
        accounts.put("003948", new Account("003948", "Microsoft Gate", 55120000.0, true));

        //Initialize with dummy accounts
        archivedAccount.put("6643375", new Account("6643375", "Instagram User", 57840000.0, false));

        //Initialize with dummy transactions
        transactions.put(TRANSFER, new ArrayList<>());
        transactions.put(BILL_PAY, new ArrayList<>());
        transactions.put(DEPOSIT, new ArrayList<>());
        transactions.put(CLOSE, new ArrayList<>());

        transactions.get(TRANSFER).add(new Transaction("12345", "775866", 5000.0));
        transactions.get(BILL_PAY).add(new Transaction("12345", "003948", 5000.0));
        transactions.get(DEPOSIT).add(new Transaction("cash in/cheque", "003948", 900000.0));
        transactions.get(CLOSE).add(new Transaction("6643375", "", null));
    }

}
