package com.ayofill.bankapp.util;

import com.ayofill.bankapp.model.Account;

import java.util.HashMap;
import java.util.Map;

/**
 * @author afilegbe
 */
public class Util {
    public static Map<String, Account> accounts = new HashMap<String, Account>();
    public static Map<String, Account> archivedAccount = new HashMap<String, Account>();

    /**
     * uncomment when Transaction class has been created under the model package
     */
    //public static Map<String, Transaction> transactions = new HashMap();
    static {
        accounts.put("12345", new Account("12345", "John Bill", 50000.0));
        accounts.put("775866", new Account("775866", "Amazon Bezos", 500000.0));
        accounts.put("135856", new Account("135856", "Facebook Mark", 150000.0));
        accounts.put("003948", new Account("003948", "Microsoft Gate", 550000.0));
        accounts.put("6643375", new Account("6643375", "Instagram User", 57840000.0));
    }

}
