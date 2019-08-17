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
    public static Map<String, Account> accounts = new HashMap<>();
    public static Map<String, Account> archivedAccount = new HashMap<>();
    public static Map<String, List<Transaction>> transactions = new HashMap<>();

    public static final String TRANSFER = "Transfer";
    public static final String BILL = "Bill";
    public static final String DEPOSIT = "Deposit";


    static {
        //Initialize with dummy accounts
        accounts.put("12345", new Account("12345", "John Bill", 5430000.0, true));
        accounts.put("775866", new Account("775866", "Amazon Bezos", 59800000.0, true));
        accounts.put("135856", new Account("135856", "Facebook Mark", 9150000.0, true));
        accounts.put("003948", new Account("003948", "Microsoft Gate", 55120000.0, true));

        //Initialize with dummy accounts
        archivedAccount.put("6643375", new Account("6643375", "Instagram User", 57840000.0, true));

        //Initialize with dummy transactions
        transactions.put(TRANSFER, new ArrayList<>());
        transactions.put(BILL, new ArrayList<>());
        transactions.put(DEPOSIT, new ArrayList<>());
        transactions.get(TRANSFER).add(new Transaction("12345", "775866", 5000.0));
        transactions.get(BILL).add(new Transaction("12345", "003948", 5000.0));
        transactions.get(DEPOSIT).add(new Transaction("003948", null, 900000.0));
    }

}
